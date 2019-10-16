$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/adresse.feature");
formatter.feature({
  "name": "Modifier l\u0027adresse d\u0027un abonné",
  "description": "",
  "keyword": "Fonctionnalité"
});
formatter.scenarioOutline({
  "name": "",
  "description": "Modification de l\u0027adresse d\u0027un abonne residant en France sans ou avec date d\u0027effet",
  "keyword": "Plan du Scénario"
});
formatter.step({
  "name": "un abonne avec une adresse principale \u003cactive\u003e en \u003cpays\u003e",
  "keyword": "Etant donné "
});
formatter.step({
  "name": "le conseiller connecte a \u003ccanal\u003e modifie l\u0027adresse de l\u0027abonne \u003ccondition\u003e",
  "keyword": "Lorsque "
});
formatter.step({
  "name": "l\u0027adresse de l\u0027abonne modifiee est enregistree sur l\u0027ensemble des contrats de l\u0027abonne",
  "keyword": "Alors "
});
formatter.step({
  "name": "un mouvement de modification d\u0027adresse est cree",
  "keyword": "Et "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemples",
  "rows": [
    {
      "cells": [
        "canal",
        "active",
        "pays",
        "condition"
      ]
    },
    {
      "cells": [
        "FACE",
        "inactive",
        "France",
        "sans date d\u0027effet"
      ]
    },
    {
      "cells": [
        "EC",
        "active",
        "Pologne",
        "avec date d\u0027effet"
      ]
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "Modification de l\u0027adresse d\u0027un abonne residant en France sans ou avec date d\u0027effet",
  "keyword": "Plan du Scénario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un abonne avec une adresse principale inactive en France",
  "keyword": "Etant donné "
});
formatter.match({
  "location": "AdresseStepDef.adressePrincipale(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "le conseiller connecte a FACE modifie l\u0027adresse de l\u0027abonne sans date d\u0027effet",
  "keyword": "Lorsque "
});
formatter.match({
  "location": "AdresseStepDef.modificationAdresseAbonne(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "l\u0027adresse de l\u0027abonne modifiee est enregistree sur l\u0027ensemble des contrats de l\u0027abonne",
  "keyword": "Alors "
});
formatter.match({
  "location": "AdresseStepDef.ladresse_de_labonne_modifiee_est_enregistree_sur_lensemble_des_contrats_de_labonne()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "un mouvement de modification d\u0027adresse est cree",
  "keyword": "Et "
});
formatter.match({
  "location": "AdresseStepDef.un_mouvement_de_modification_d_adresse_est_cree()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "",
  "description": "Modification de l\u0027adresse d\u0027un abonne residant en France sans ou avec date d\u0027effet",
  "keyword": "Plan du Scénario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un abonne avec une adresse principale active en Pologne",
  "keyword": "Etant donné "
});
formatter.match({
  "location": "AdresseStepDef.adressePrincipale(String,String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [France] but found [Pologne]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:453)\r\n\tat org.testng.Assert.assertEquals(Assert.java:463)\r\n\tat starter.stepdefinitions.AdresseStepDef.adressePrincipale(AdresseStepDef.java:61)\r\n\tat ✽.un abonne avec une adresse principale active en Pologne(src/test/resources/features/adresse.feature:5)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "le conseiller connecte a EC modifie l\u0027adresse de l\u0027abonne avec date d\u0027effet",
  "keyword": "Lorsque "
});
formatter.match({
  "location": "AdresseStepDef.modificationAdresseAbonne(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "l\u0027adresse de l\u0027abonne modifiee est enregistree sur l\u0027ensemble des contrats de l\u0027abonne",
  "keyword": "Alors "
});
formatter.match({
  "location": "AdresseStepDef.ladresse_de_labonne_modifiee_est_enregistree_sur_lensemble_des_contrats_de_labonne()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "un mouvement de modification d\u0027adresse est cree",
  "keyword": "Et "
});
formatter.match({
  "location": "AdresseStepDef.un_mouvement_de_modification_d_adresse_est_cree()"
});
formatter.result({
  "status": "skipped"
});
});