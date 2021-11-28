import React, { useContext, useRef, useState } from "react";
import { useForm } from "react-hook-form";
import ApiTask from "./ApiTask";
import events from "../eventsAction";
import Store from "../store";

const FormView = ({listId, todo}) => {
  const formRef = useRef(null);
  const { register } = useForm();
  const { dispatch } = useContext(Store);
  const item = todo.item[listId] ? todo.item[listId] : {};
  const [state, setState] = useState(item);
  const [requiredName, setRequiredName] = useState(false);

  const onAdd = (event) => {
    event.preventDefault();

    if(Boolean(state.name) === false){
      setRequiredName(true);
      return 
    }
    setRequiredName(false);

    const request = {
      name: state.name,
      id: null,
      completed: false,
    };

    ApiTask.save(listId, request).then((response) => {
      response.json().then((result) => {
        dispatch(events.saveTask(listId, result));
        setState({ name: "" });
        formRef.current.reset();
      });
    });
  };

  const onEdit = (event) => {
    event.preventDefault();

    if (state.name === undefined) {
      state.name = item.name
    }

    const request = {
      name: state.name,
      id: item.id,
      completed: item.completed,
      idList: item.idList
    };


    ApiTask.update(listId, request).then((response) => {
      if (response.ok) {
        response.json().then((result) => {
          dispatch(events.updateTask(listId, result));
          setState({ name: "" });
          formRef.current.reset();
        });
      }
    });
  };

  return (
    <form ref={formRef}>
      <input
        type="text"
        { ...register("name",{
          required:{
            value: true,
            message: "Nombre requerido"
          },
        })}
        defaultValue={item.name}
        placeholder="¿Qué piensas hacer?"
        onChange={(event) => {
          setState({ ...state, name: event.target.value });
        }}
      ></input>
      {item.id && <button onClick={onEdit}>Actualizar</button>}
      {!item.id && <button onClick={onAdd}>Crear</button>}
      {!item.id && requiredName && <p className="text-danger">Debe ingresar un nombre para la tarea</p>}
    </form>
  )
}

export default FormView;
