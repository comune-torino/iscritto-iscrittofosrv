# Project Title
ISCRITTO-ISCRITTOFOSRV

# Project Description
Questa componente espone servizi REST di back-end per il front-end (iscrittofe) di gestione domanda di iscrizione ai nidi e materne

# Configurations
Aprire il file buildfiles/dev-rp-01.properties e configurare i seguenti parametri:
- nao.ws.base.service.url: url dei servizi di fruizione della Nuova anagrafe open;
- nao.ws.auth.user: user dei servizi di fruizione della Nuova anagrafe open;
- nao.ws.auth.password: password dei servizi di fruizione della Nuova anagrafe open;
- notificatore.ws.preferences.url: url del servizio REST per l'impostazione delle preferenze sul Notificatore;
- notificatore.ws.preferences.tokenjwt: x-authentication per contattare il Notificatore;

# Getting Started 
Clonare la componente iscritto-iscrittofosrv dal repository git 
Modificare i file di configurazione e compilare il progetto.

# Prerequisites
I prerequisiti per l'installazione della componente sono i seguenti:
## Software
- [JDK 8](https://www.apache.org)
- [RedHat JBoss 6.4 GA](https://developers.redhat.com)  
- [PostgreSQL 9.6.11](https://www.postgresql.org/download/)  

- Tutte le librerie elencate nel BOM.csv devono essere accessibili per compilare il progetto. Le librerie sono pubblicate su http://repart.csi.it, ma per semplicità sono state incluse nella cartella lib/, ad esclusione della libreria weblogic-client-3.0.0.jar che deve essere scaricata autonomamente dal sito di Oracle.

# Installing
Installare il file ear sull'ambiente JBoss 6.4. 

# Versioning
Per la gestione del codice sorgente viene utilizzata Git. Per la gestione del versioning si fa riferimento alla metodologia [Semantic Versioning](https://semver.org/).

# Copyrights
(C) Copyright 2021 Città di Torino

# License
Questo software è distribuito con licenza EUPL-1.2
Consultare i file EUPL v1_2 IT-LICENSE.txt e EUPL v1_2 EN-LICENSE.txt per maggiori dettagli.

