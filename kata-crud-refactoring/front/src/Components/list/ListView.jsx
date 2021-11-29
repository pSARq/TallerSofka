import React, { useState, useContext, useEffect } from 'react';
import ToDoForm from "../todo/FormView.jsx";
import ToDoList from "../todo/ListView.jsx";
import ApiList from "./ApiList";
import events from "../eventsAction";
import Store from "../store"

function ListView(){
    const { state: { list, todo }, dispatch } = useContext(Store);
    const [isLoaded, setLoaded] = useState(false);
    //Muestra las listas de tareas
    useEffect(() => {
        ApiList.findAll().then((response) => {
            if(response.ok) {
                response.json().then((list) => {
                    dispatch(events.findList(list));
                });
            }
            setLoaded(true);
        })
    }, [dispatch]);

    //Elimina una lista de tareas
    const onDelete = (listId) => {
        ApiList.delete(listId).then((response) => {
            if(response.ok) {
                dispatch(events.deleteList(listId));
            }
        })
    };

    //Muestra las listas de tareas
    return <div>
        {!isLoaded && <div>Loading</div>}
        {list.elements.length === 0 && <div>empty list!</div>}
        {list.elements.map((element) => {
            return <div key={element.id} id={"list-to-do-"+element.id}>
                <fieldset>
                    <legend>
                        {element.name.toUpperCase()}
                        <button onClick={() => onDelete(element.id)}>Eliminar</button>
                    </legend>
                    <ToDoForm listId={element.id} todo={todo} />
                    <ToDoList listId={element.id} todo={todo} />
                </fieldset>
            </div>
        })}
    </div>
}

export default ListView