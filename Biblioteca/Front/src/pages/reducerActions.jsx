import { TYPE } from "../eventsActions";

export function reducerActions(state, action) {
  switch (action.type) {

    case TYPE.USER_CREATE:{

    }
    case TYPE.USER_DELETE:{
        
    }
    case TYPE.USER_FIND:{
        
    }
    case TYPE.USER_UPDATE:{
        
    }

    default:
      return state;
  }
}
