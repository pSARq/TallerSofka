//Son los tipos de acciones
export const TYPE = {
  TASK_CREATE: "item.TASK_CREATE",
  TASK_UPDATE: "item.TASK_UPDATE",
  TASK_FIND: "item.TASK_FIND",
  TASK_DELETE: "item.TASK_DELETE",
  TASK_ON_EDIT: "item.TASK_ON_EDIT",
  LIST_CREATE: "list.LIST_CREATE",
  LIST_FIND: "list.LIST_FIND",
  LIST_DELETE: "list.LIST_DELETE",
};

//Son las acciones que puede ejecutar el reducer
export default {
  saveTask: (idList, item) => ({
    type: TYPE.TASK_CREATE,
    item,
    idList,
  }),
  deleteTask: (idList, itemId) => ({
    type: TYPE.TASK_DELETE,
    itemId,
    idList,
  }),
  updateTask: (idList, item) => ({
    type: TYPE.TASK_UPDATE,
    item,
    idList,
  }),
  onEdited: (idList, item) => ({
    type: TYPE.TASK_ON_EDIT,
    item,
    idList,
  }),
  findTask: (idList, items) => ({
    type: TYPE.TASK_FIND,
    items,
    idList,
  }),
  saveList: (item) => ({
    type: TYPE.LIST_CREATE,
    item,
  }),
  findList: (list) => ({
    type: TYPE.LIST_FIND,
    list,
  }),
  deleteList: (listId) => ({
    type: TYPE.LIST_DELETE,
    listId,
  }),
};
