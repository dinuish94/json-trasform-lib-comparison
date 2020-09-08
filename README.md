# JSON Transformation Libraries Comparison

## How to Run
* Clone the project and go to the project root directory.
* Run `mvn spring-boot:run`
* Send a `GET` request to `http://localhost:8080/demo/freemarker` (to execute the freemerker example)
* Paths for different implementations
    * Freemarker - freemarker
    * JOLT - jolt
    * Liquid - liquid
    * JSONata - jsonata
    * JMESPath - jmespath
    * JSLT - jslt
    * Swamill - swamill
## Implementations
* JOLT - com.example.json.demo.service.JoltService
* Freemarker - com.example.json.demo.service.FreeMarkerService
* Liquid - com.example.json.demo.service.LiquidService
* JSONata - com.example.json.demo.service.JsonataService
* JMESPath - com.example.json.demo.service.JmespathService
* JSLT - com.example.json.demo.service.JsltService
* Swamill - com.example.json.demo.service.SwamillService

## Transformation JSON

### Features in the example
* Remaining a value as it is (transactionId)
* Changing value location(crsPageNumber, brandId etc.)
* Removing a value (Removing itinerary.reservations.action)

### Input

```json
{
  "itinerary": {
    "reservationId": {
      "crsConfirmationId": "24955269",
      "crsPageNumber": 2345
    },
    "reservations": [
      {
        "property": {
          "propertyId": "JEDHR",
          "brand": {
            "brandId": "HYATT",
            "name": "ABC",
            "logo": null
          }
        },
        "action": "ADD"
      }
    ]
  },
  "transactionId": "2801913"
}
```

### Output

```json
{
    "itinerary": {
        "reservationId": {
            "crsConfirmationId": {
                "string": "24955269"
            },
            "crsPageNumber": 2345
        },
        "reservations": {
            "array": [
                {
                    "property": {
                        "com.hyatt.choice.resort.Property": {
                            "propertyId": "JEDHR",
                            "brand": {
                                "com.hyatt.choice.resort.Brand": {
                                    "brandId": "HYATT",
                                    "name": "ABC",
                                    "logo": null
                                }
                            }
                        }
                    }
                }
            ]
        }
    },
    "transactionId": "2801913"
}
```