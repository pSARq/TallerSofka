import { createEvent } from "./functions";

//Globales
const weekday = "mon";
const week = 1;
const openHour = 8;
const closeHour = 14;
const result = createEvent(weekday, week, openHour, closeHour);

test("Validation a event title and content basic", () => {
  expect(result.title).toBe("[SOFKA U] Meeting Room");
  expect(result.description).toBe("Mentoring and Practice");
  expect(result.duration).toEqual([6, "hour"]);
});

test("Validation start date", () => {
  const date = new Date(new Date().setDate(new Date().getDate() - 1)).toUTCString();
  const dateStart = result.start.toUTCString();
  expect(dateStart).toStrictEqual(date);
});

test("Validation date", () => {
  expect(result.date).toBe("lunes, 6 de diciembre de 2021");
});

describe("Validation illegal arguments", () => {
  test("Invalid weekday", () => {
    const weekday = () => {
      createEvent(1, week, openHour, closeHour);
    };
    expect(weekday).toThrow(Error);
  });

  test("Invalid week", () => {
    const week = () => {
      createEvent(weekday, -1, openHour, closeHour);
    };
    expect(week).toThrow(Error);
  });

  test("Invalid openHour or closeHour", () => {
    const openHour = () => {
      createEvent(weekday, week, 2, 1);
    };
    expect(openHour).toThrow(Error);
  });
});

test("create an event list of at least 10 events", () => {
  const events = [
    {
      weekday: "mon",
      week: 1,
      openHour: 1,
      closeHour: 2
    },{
      weekday: "tue",
      week: 2,
      openHour: 1,
      closeHour: 3
    },{
      weekday: "wed",
      week: 3,
      openHour: 1,
      closeHour: 4
    },{
      weekday: "thu",
      week: 4,
      openHour: 1,
      closeHour: 5
    },{
      weekday: "fri",
      week: 5,
      openHour: 1,
      closeHour: 6
    },{
      weekday: "sat",
      week: 6,
      openHour: 1,
      closeHour: 7
    },{
      weekday: "sun",
      week: 7,
      openHour: 1,
      closeHour: 8
    },{
      weekday: "mon",
      week: 8,
      openHour: 1,
      closeHour: 9
    },{
      weekday: "tue",
      week: 9,
      openHour: 1,
      closeHour: 10
    },{
      weekday: "wed",
      week: 10,
      openHour: 1,
      closeHour: 11
    }
  ]

  events.map((event) =>{
    const resultMap = createEvent(event.weekday, event.week, event.openHour, event.closeHour)

    expect(resultMap.title).toBe("[SOFKA U] Meeting Room");
    expect(resultMap.description).toBe("Mentoring and Practice");

    expect(resultMap.duration).toEqual([event.closeHour - event.openHour, "hour"])
  })
});
