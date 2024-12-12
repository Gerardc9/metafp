const { CalculaTipo } = require("../index");

describe("Pruebas para la función CalculaTipo", () => {
  // Bloque de pruebas para probar todos los valores de 0 a 5.
  test("Debe devolver 5 cuando venta >= 500 y factor = 100", () => {
    expect(CalculaTipo(500, 0)).toBe(5);
  });

  test("Debe devolver 4 cuando venta >= 500 y factor > 50", () => {
    expect(CalculaTipo(600, 200)).toBe(4);
  });

  test("Debe devolver 3 cuando venta < 500 y factor > 50", () => {
    expect(CalculaTipo(400, 100)).toBe(3);
  });

  test("Debe devolver 2 cuando venta < 500 y factor <= 50", () => {
    expect(CalculaTipo(400, 300)).toBe(2);
  });

  test("Debe devolver 1 cuando venta >= 500 y factor <= 50 y factor != 0", () => {
    expect(CalculaTipo(600, 550)).toBe(1);
  });

  test("Debe devolver 0 cuando venta >= 500 y factor = 0", () => {
    expect(CalculaTipo(500, 500)).toBe(0);
  });

  //Verificamos rango
  test("Debe devolver un valor entre 0 y 5 para cualquier entrada válida", () => {
    const resultado = CalculaTipo(1000, 500);
    expect(resultado).toBeGreaterThanOrEqual(0);
    expect(resultado).toBeLessThanOrEqual(5);
  });

  // Se podría añadir un test también que devuelva 0 en caso de entradas inválidas, es decir, null, undefined o letras por ejemplo.
  // pero para eso habría que modificar lógica del index.js
});
