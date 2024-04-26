const Navbar = () => {
    return (
        <nav className="navbar">
            <h1>Baza filmów</h1>
            <div className="links">
                <a href="/">Strona główna</a>
                <a href="/create"> Dodaj film</a>
            </div>
        </nav>
    );
}

export default Navbar;