import React, { useReducer, createContext } from "react";
import reducerActions from "./reducerActions";

//Inicializa los elementos de tarea y lista de tarea
const initialState = {
  list: {
    elements: [],
  },
  todo: {
    elements: [],
    item: {},
  },
  mensage: {},
};
const Store = createContext(initialState);

//Devuelve el objeto reducer de la importación reducerActions
function reducer(state, action) {
  return reducerActions()[action.type] ? reducerActions()[action.type](state, action) : state;
}

//Nos permite conectar los diferentes componentes indicandondole al reducer que realizar  
export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};

export default Store;
