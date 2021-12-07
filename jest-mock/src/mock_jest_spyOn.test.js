import * as app from "./App";
import * as math from "./math";

test("calls math.add", () =>{
    const addMock = jest.spyOn(math, "add");
    expect(app.doAdd(1, 2)).toEqual(3);
    expect(addMock).toHaveBeenCalledWith(1, 2)
});