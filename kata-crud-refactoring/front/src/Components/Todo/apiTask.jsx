const HOST_API = "http://localhost:8080/api/"
export default{
    findAll: async (idList) =>{
        return fetch(HOST_API+ "tasks/"+ idList).catch(error => console.error("Error: ", error))
    },
    save: async (idList, request) =>{
        return fetch(HOST_API+ "task/"+ idList,{
            method:"POST",
            body:JSON.stringify(request),
            headers:{
                'Content-Type': 'application/json'
            }
        }).catch(error => console.error("Error: ", error))
    },
    update: async (idList, request) =>{
        return fetch(HOST_API+ "updateTask/"+ idList,{
            method:"PUT",
            body:JSON.stringify(request),
            headers:{
                'Content-Type': 'application/json'
            }
        }).catch(error => console.error("Error: ", error))
    },
    delete: async (id) =>{
        return fetch(HOST_API+ "delTask/"+ id,{
            method:"DELETE",
            headers:{
                "Content_Type": "application/json"
            }
        }).catch(error => console.error("Error: ", error)) 
    }
};