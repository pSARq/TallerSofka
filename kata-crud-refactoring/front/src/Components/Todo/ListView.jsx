import React, { useContext, useEffect, useState } from "react";
import ApiTask from "./ApiTask";
import events from "../eventsAction";
import Store from "../store";

function ListView({listId, todo}){
  const { dispatch } = useContext(Store);
  const [isLoaded, setLoaded] = useState(true);
  const list = todo.elements.filter((element) => {
    return element.idList === listId;
  });
  useEffect(() => {
    ApiTask.findAll(listId).then((response) => {
      if (response.ok) {
        response.json().then((items) => {
          setLoaded(true);
          dispatch(events.findTask(listId, items));
        });
      }
    });
  }, [listId, dispatch]);

  const onDelete = (itemId) => {
    ApiTask.delete(itemId).then((response) => {
      if (response.ok) {
        dispatch(events.deleteTask(listId, itemId));
      }
    });
  };

  const onEdit = (item) => {
    dispatch(events.onEdited(listId, item));
  };

  const onChange = (event, item) => {
    const request = {
      name: item.name,
      id: item.id,
      completed: event.target.checked,
      idList: item.idList
    };
    ApiTask.update(listId, request).then((response) => {
      if (response.ok) {
        response.json().then(() => {
          dispatch(events.updateTask(listId, request));
        });
      }
    });
  };

  const decorationDone = {
    textDecoration: "line-through",
    color: "red",
  };
  return (
    <div>
      {!isLoaded && <div>Loading...</div>}
      <table>
        <thead>
          <tr>
            <td>ID</td>
            <td>Tarea</td>
            <td>¿Completado?</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          {list.map((todo) =>{
            return(
            <tr
              key={todo.id}
              style={todo.completed ? decorationDone : {}}
              id={"to-do-" + todo.id}
            >
              <td>{todo.id}</td>
              <td>{todo.name}</td>
              <td>
                <input
                  type="checkbox"
                  defaultChecked={todo.completed}
                  onChange={(event) => onChange(event, todo)}
                ></input>
              </td>
              <td>
                <button onClick={() => onDelete(todo.id)}>Eliminar</button>
              </td>
              <td>
                <button disabled={todo.completed} onClick={() => onEdit(todo)}>
                  Editar
                </button>
              </td>
            </tr>
            )
          })}
        </tbody>
      </table>
    </div>
  )
}

export default ListView;
