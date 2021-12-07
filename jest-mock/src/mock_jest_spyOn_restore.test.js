import * as app from "./App";
import * as math from "./math";

test("calls math.add", () =>{
    const addMock = jest.spyOn(math, "add");

    addMock.mockImplementation(() => "mock");
    expect(app.doAdd(1, 2)).toEqual("mock");

    addMock.mockRestore();
    expect(app.doAdd(1, 2)).toEqual(3);
})
