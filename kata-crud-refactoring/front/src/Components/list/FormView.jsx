import React, { useContext, useState, useRef } from 'react';
import ApiList from "./ApiList";
import events from "../eventsAction";
import Store from "../store"

const FormView = () =>{
    const { dispatch } = useContext(Store);
    const formRef = useRef(null);
    const [state, setState] = useState({ name: "" });
    const [requiredName, setRequirdName] = useState(false);

    const onCreate = (event) => {

        if(Boolean(state.name) === false){
            setRequirdName(true)
            return event.preventDefault();
        }
        setRequirdName(false)

        event.preventDefault();
        ApiList.save({ name: state.name, id: null })
            .then((response) => {
                if (response.ok) {
                    response.json().then((newList) => {
                        dispatch(events.saveList(newList));
                        formRef.current.reset();
                        setState({ name: "" })
                    })
                }
            });

    };

    return <form ref={formRef}>
        <input
            type="text"
            name="name"
            placeholder="Lista de TO-DO"
            onChange={(event) => {
                setState({ name: event.target.value })
            }}  ></input>
        <button onClick={onCreate}>Nueva lista</button>
        {requiredName && <p className="text-danger">Debe agregarle un nombre a la lista de tareas</p>}
    </form>
}

export default FormView;
