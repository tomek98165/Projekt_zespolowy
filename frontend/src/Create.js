import { useState } from "react";
import { useHistory } from "react-router-dom";

const Create = (movie) => {


      const [id, setId] = useState(movie.id);
      const [title, setTitle] = useState(movie.title);
      const [description, setDescription] = useState(movie.description);
      const [director, setDirector] = useState(movie.director);
      const [isPending, setIsPending] = useState(false);
      const history = useHistory();
  
      const handleSubmit = (e) =>{
          e.preventDefault();
          const movie = { title, description, director};
  
          setIsPending(true);
  
          fetch('http://localhost:8080/movies', {
              method: 'POST',
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify(movie)
          }).then(() => {
              setIsPending(false);
              // history.go(-1);
              history.push('/')
          })
      }
  
      return (
          <div className="create">
              <h2>Dodaj nowy film</h2>
              <form onSubmit={handleSubmit}>
                <p>
                  <label>Tytuł filmu:</label>
                  <input 
                      type="text"
                      required
                      value = { title }
                      onChange={(e) => setTitle(e.target.value)}
                  />
                  <label>Opis filmu:</label>
                  <textarea
                  value = { description }
                  onChange={(e) => setDescription(e.target.value)}
                      required
                  />
                  </p>
                  <p>
                  <label>Reżyser filmu:</label>
                  <input 
                      type="text"
                      required
                      value = { director }
                      onChange={(e) => setDirector(e.target.value)}
                  /></p>
                    <p>
                      { !isPending && <button>Dodaj film</button> }
                      { isPending && <button disabled>Dodawanie filmu</button> }   

                    </p>

              </form>
          </div>
      )
  }
   
  export default Create;