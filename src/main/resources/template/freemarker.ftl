{
	"itinerary": {
		"reservationId": {
			"crsConfirmationId": {
				"string": "${crsConfirmationId}"
			},
			"crsPageNumber": ${crsPageNumber}
		},
		"reservations": {
			"array": [{
				"property": {
					"com.hyatt.choice.resort.Property": {
						"propertyId": "${propertyId}",
						"brand": {
							"com.hyatt.choice.resort.Brand": {
								"brandId": "${brandId}",
								"name": ${brandName},
								"logo": ${brandLogo}
							}
						}
					}
				}
			}]
		}
	},
	"transactionId": "${transactionId}"
}
