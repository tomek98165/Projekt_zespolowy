import MovieList from "./MovieList";
import useFetch from "./useFetch";

const Home = () => {
    const {data, isPending, error} = useFetch('http://localhost:8000/movies');

    return (
        <div className="home">
          { error && <div>{ error }</div> }
          { isPending && <div>Ładowanie...</div> }
          { data && <MovieList movies={data} /> }
        </div>
    );
}
export default Home;