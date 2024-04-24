const MovieList = ({movies, title, handleDelete}) => {

    return (
        <div className="movie-list">
            <h2>{title}</h2>
            {movies.map(movie => (
                <div className="movie-preview" key={movie.id} >
                    <h2>{ movie.title }</h2>
                    <p>Reżyser: { movie.author}</p>
                </div>
            ))}
        </div>
    );
}

export default MovieList;