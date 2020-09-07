# JSON Transformation Libraries Comparison

## How to Run
* Clone the project and go to the project root directory.
* Run `mvn spring-boot:run`
* Send a `GET` request to `http://localhost:8080/demo/freemarker` (to execute freemerker example.)
* Path for different implementations
    * Freemarker - freemarker
    * JOLT - jolt
    * Liquid - liquid
## Implementations
* JOLT - com.example.json.demo.service.JoltService
* Freemarker - com.example.json.demo.service.FreeMarkerService
* Liquid - com.example.json.demo.service.LiquidService

## Transformation JSON

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
                    },
                    "action": {
                        "com.hyatt.choice.enums.ReservationAction": "ADD"
                    }
                }
            ]
        }
    },
    "transactionId": "2801913"
}
```