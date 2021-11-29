import { TYPE } from "./eventsAction";

//Retorna las diferentes acciones que puede ejecutar el reducer
export default () => {
  const action = {};

  action[TYPE.LIST_FIND] = (state, action) => {
    return { ...state, list: { elements: action.list } };
  };

  action[TYPE.LIST_CREATE] = (state, action) => {
    const list = state.list.elements;
    list.push(action.item);
    return { ...state, list: { elements: list } };
  };

  action[TYPE.LIST_DELETE] = (state, action) => {
    const list = state.list.elements.filter((element) => {
      return element.id !== action.listId;
    });
    return { ...state, list: { elements: list } };
  };

  action[TYPE.TASK_FIND] = (state, action) => {
    const list = state.todo.elements;
    action.items.forEach((element) => {
      list.push(element);
    });
    return { ...state, todo: { elements: list, item: {} } };
  };

  action[TYPE.TASK_CREATE] = (state, action) => {
    const list = state.todo.elements;
    list.push(action.item);
    return { ...state, todo: { elements: list, item: {} } };
  };

  action[TYPE.TASK_ON_EDIT] = (state, action) => {
    const editToDo = { ...state.todo };
    editToDo.item[action.idList] = action.item;
    return { ...state, todo: editToDo };
  };

  action[TYPE.TASK_UPDATE] = (state, action) => {
    const list = state.todo.elements.map((element) => {
      if (element.id === action.item.id) {
        return { ...action.item, idList: action.idList };
      }
      return element;
    });
    return { ...state, todo: { elements: list, item: {} } };
  };

  action[TYPE.TASK_DELETE] = (state, action) => {
    const list = state.todo.elements.filter((element) => {
      return element.id !== action.itemId;
    });
    return { ...state, todo: { elements: list, item: {} } };
  };

  return action;
};
