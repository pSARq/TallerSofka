import { BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import Home from "./Components/Home/Home.jsx"
import Navbar from "./Components/Navbar/Navbar.jsx";

function App() {
  return (
    <Router>
      <Navbar />
        <Routes>
          <Route path="/" element={<Home/>}/>
        </Routes>
    </Router>
  );
}

export default App;
