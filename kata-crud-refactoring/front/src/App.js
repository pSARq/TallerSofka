import React from "react";
import { StoreProvider } from "./Components/store";
import ListView from "./Components/list/ListView";
import FormView from "./Components/list/FormView";

//Se mandan a llamar los diferentes componentes que se han creado
function App() {
  return (
    <StoreProvider>
      <div className="title">
        <h3>Dashboard</h3>
      </div>
      <div className="container">
        <div className="content">
          <FormView />
          <ListView />
        </div>
      </div>
    </StoreProvider>
  );
}

export default App;
