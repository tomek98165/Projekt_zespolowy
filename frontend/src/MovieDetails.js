import {useParams} from "react-router-dom";
import useFetch from "./useFetch";
import { Link, useHistory } from "react-router-dom/cjs/react-router-dom.min";

const MovieDetails = () => {
        const {id} = useParams();
        const { data: movie, error, isPending } = useFetch("http://localhost:8080/movies/" + id);
        const history = useHistory();

        const handleClickDelete= () => {
            fetch('http://localhost:8080/movies/' + id,{
                method: 'DELETE'
            }).then(() => {
                history.push("/")
            }) 
        }
    return (
        <div className="movie-details">
            { isPending && <div>Loading...</div> }
            { error && <div>{ error }</div>}
            {movie && (
                <article>
                    <h2>{ movie.title }</h2>
                    <p>Wyreżyserował: { movie.director }</p>
                    <div>{ movie.description }</div>
                    <button class="delete-button" onClick={handleClickDelete}>Delete</button>
                    {/* <Link class="edit-button" to={{pathname: '/create', state: movie}}>Edytuj</Link> */}

                </article>
            )}
        </div>
    );
}
 
export default MovieDetails;