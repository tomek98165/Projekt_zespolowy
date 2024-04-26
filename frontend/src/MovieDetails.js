import {useParams} from "react-router-dom";

const MovieDetails = () => {
    const MovieDetails = () => {
        const {id} = useParams();
    }
    return (
        <div className="movie-details">
            <h1>Szczególy filmu</h1>
        </div>
    );
}
 
export default MovieDetails;