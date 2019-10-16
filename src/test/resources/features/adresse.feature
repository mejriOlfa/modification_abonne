# language: fr
Fonctionnalité: Modifier l'adresse d'un abonné
Plan du Scénario:
Modification de l'adresse d'un abonne residant en France sans ou avec date d'effet
Etant donné un abonne avec une adresse principale <active> en <pays>
Lorsque le conseiller connecte a <canal> modifie l'adresse de l'abonne <condition>
Alors l'adresse de l'abonne modifiee est enregistree sur l'ensemble des contrats de l'abonne
Et un mouvement de modification d'adresse est cree
Exemples:
| canal | active | pays | condition |
| FACE | inactive |France | sans date d'effet |
| EC | active |Pologne |avec date d'effet |