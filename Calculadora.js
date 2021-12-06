//Define que operacion realizar
const operacion = (valor) =>{
  let numero1 = Number(document.getElementById("numero1").value)
  let numero2 = Number(document.getElementById("numero2").value)
  let resultado
  
  switch (valor) {
    case sumar:
      resultado = sumar(numero1, numero2)
      break;
    case restar:
      resultado = restar(numero1, numero2)
      break;
    case multiplicar:
      resultado = multiplicar(numero1, numero2)
      break;
    case dividir:
      resultado = dividir(numero1, numero2)
      break;
  }

  document.getElementById("resultado").value = resultado
}

//Operaciones de forma funcional
const sumar = (num1, num2) => {
  return num1 + num2
}

const restar = (num1, num2) => {
  return num1 - num2
}

const multiplicar = (num1, num2) => {
  if (num1<=0 || num2<=0 ){
    return "Ingrese un número mayor de 0"
  }
  return [...Array(num2+1).keys()].reduce((acumulacion, actual) => acumulacion + num1)
}

//Division entera
const dividir = (num1, num2) => {
  if (num1<=0 || num2<=0 ){
    return "Ingrese un número mayor de 0"
  }
  return [...Array(num2+1).keys()].reduce((acumulacion, actual) => {
    if (multiplicar(actual, num2) <= num1) {
      return acumulacion += 1
    }
      return acumulacion
  })
}

// console.log(sumar(1, 2))
// console.log(restar(1, 2))
// console.log(multiplicar(3, 3))
// console.log(dividir(10, 2))
