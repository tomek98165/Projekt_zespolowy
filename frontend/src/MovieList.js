import { Link } from "react-router-dom";

const MovieList = ({movies, title}) => {

    return (
        <div className="movie-list">
            <h2>{title}</h2>
            {movies.map(movie => (
                <div className="movie-preview" key={movie.id} >
                    <Link to={`/movies/${movie.id}`}>
                        <h2>{ movie.title }</h2>
                        <p>Reżyser: { movie.director}</p>
                    </Link>
                </div>
            ))}
        </div>
    );
}

export default MovieList;