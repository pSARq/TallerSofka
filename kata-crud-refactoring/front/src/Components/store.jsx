import React, { useReducer, createContext } from "react";
import reducerActions from "./reducerActions";

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

function reducer(state, action) {
  return reducerActions()[action.type] ? reducerActions()[action.type](state, action) : state;
}

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};

export default Store;
