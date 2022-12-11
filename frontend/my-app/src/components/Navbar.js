import {Link} from "react-router-dom";

function Navbar() {
    return (
        <>
            <nav className="navbar navbar-light bg-light">
                <span className="navbar-brand mb-0 mx-3 h1"><h1 class="text-info">My Investments</h1></span>
                <span className="float-right"><Link to="/"><h3>Home</h3></Link></span>
                <span className="float-right"><Link to="/property"><h3>Properties</h3></Link></span>
                <span className="float-right mx-5"><Link to="/tenant"><h3>Tenants</h3></Link></span>

            </nav>
        </>
    );
}

export default Navbar;