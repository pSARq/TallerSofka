import * as app from "./App";
import * as math from "./math";

jest.mock("./math.js");

test("calls math.add", () =>{
    app.doAdd(1, 2);
    expect(math.add).toHaveBeenCalledWith(1, 2)
});

test("calls math.subtract", () =>{
    app.doSubtract(1, 2);
    expect(math.subtract).toHaveBeenCalledWith(1, 2)
});