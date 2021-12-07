import * as app from "./App";
import * as math from "./math";

test("calls math.add", () =>{

    //Guarda la implementación original de math.add
    const originalAdd = math.add;
    //crea el mock para math.add
    math.add = jest.fn(originalAdd);

    //Comprueba que sea el resultado correcto
    expect(app.doAdd(1, 2)).toEqual(3);
    //Espia que se haya llamado a math.add con los parametros(1, 2)
    expect(math.add).toHaveBeenCalledWith(1, 2);

    //Sobreescribe la implementación de math.add
    math.add.mockImplementation(() => "mock");
    //Comprueba que al hacer el llamado retorne "mock"
    expect(app.doAdd(1, 2)).toEqual("mock");
    //Espia que se haya llamado a math.add con los parametros(1, 2)
    expect(math.add).toHaveBeenCalledWith(1, 2);

    //Se restaura la implementacion original de math.add que se habia almacenado en originalAdd
    math.add = originalAdd;
    //Comprueba que sea el resultado correcto
    expect(app.doAdd(1, 2)).toEqual(3);

});