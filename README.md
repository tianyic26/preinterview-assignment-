## Features

- Basic arithmetic operations (ADD, SUBTRACT, MULTIPLY, DIVIDE)

- Chained calculations

- RESTful API

- Extensible architecture

- Error handling for invalid operations and inputs

## Requisites
- Java
- Spring 
- JUnit

## Future Improvement:

- add support for more operation like square root, remainder etc

- add support for different data type like long, integer

- utilize logging tools like log4j


## Example Request
```json
{
    "operator":"add",
    "num1": 1,
    "num2": 2
}
```

```json
{
    "initValue": 5,
    "operations":["multiply", "add", "divide"],
    "nums": [3,1,4]
}
```
