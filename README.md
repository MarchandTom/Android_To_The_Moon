# Android_To_The_Moon

Bienvenue sur notre fabuleuse application de voyage à petit prix.
Préparez-vous à ambarquer pour un fabuleux voyage visant à découvrir ce qu'il se passe sous le capot! :)


Notre application fonctionne en trois sous-blocs:
  - La partie Android
  - Le Back End
  - L'API skyscanner
  
Notre application vous permet d'enregistrer les pays que vous avez déjà visité, et de vous proposer en fonction d'un prix limite, 10 voyages succeptibles de vous interesser!
Pour se faire elle communique avec une application [Backend node.js](https://github.com/demas59/Back_To_The_Moon) déployé à cette [adresse](https://ap5tothemoon.herokuapp.com/country).
Cette dernière communique avec [l'API skyscanner](https://rapidapi.com/skyscanner/api/skyscanner-flight-search?endpoint=5a9ca8d2e4b084deb4ea61a9), elle nous a permis de récupérer une
liste de pays que nous stockons dans notre application backend.

Il existe cependant une limitation liée à cette API. On ne peut réaliser que 50 appels par minutes. Ce qui rend parfois notre application momentanément inutilisable.

## Comment les appels au back fonctionne:

Récupération des pays:
> GET https://ap5tothemoon.herokuapp.com/country

Résultat:
>[{'name':'France','code':'FR'}]

Récupération des voyages:
> POST https://ap5tothemoon.herokuapp.com/travel

Avec comme body:
>{'maxPrice':42 ,'alreadyVisitedCountry':[{'name':'France','code':'FR'}]}

Résultat:
>[
    {
        "PlaceId": "YVAA-sky",
        "PlaceName": "Moroni",
        "CountryId": "KM-sky",
        "RegionId": "",
        "CityId": "YVAA-sky",
        "CountryName": "Comores",
        "maxPrice": 215
    }
   ]
