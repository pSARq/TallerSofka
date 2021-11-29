import { BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import Home from "./Components/Home/Home.jsx"

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<Home/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
