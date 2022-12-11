import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {
    BrowserRouter as Router,
    Routes,
    Route,
} from "react-router-dom";

import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Property from "./pages/Property";
import Tenant from "./pages/Tenant";

function App() {
  return (
      <Router>
        <Navbar />
        <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/property" element={<Property />}/>
            <Route path="/tenant" element={<Tenant />}/>
        </Routes>
      </Router>
  );
}

export default App;
