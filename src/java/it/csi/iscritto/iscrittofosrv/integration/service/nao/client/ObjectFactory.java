
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.csi.iscritto.iscrittofosrv.integration.service.nao.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault1_QNAME = new QName("urn:SrvVisuraFamiglia", "fault1");
    private final static QName _Fault3_QNAME = new QName("urn:SrvVisuraFamiglia", "fault3");
    private final static QName _Fault2_QNAME = new QName("urn:SrvVisuraFamiglia", "fault2");
    private final static QName _Fault5_QNAME = new QName("urn:SrvVisuraFamiglia", "fault5");
    private final static QName _Fault4_QNAME = new QName("urn:SrvVisuraFamiglia", "fault4");
    private final static QName _Fault_QNAME = new QName("urn:SrvVisuraFamiglia", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.csi.iscritto.iscrittofosrv.integration.service.nao.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Vector }
     * 
     */
    public Vector createVector() {
        return new Vector();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerIdSoggetto }
     * 
     */
    public DettaglioFamigliaPerIdSoggetto createDettaglioFamigliaPerIdSoggetto() {
        return new DettaglioFamigliaPerIdSoggetto();
    }

    /**
     * Create an instance of {@link DatiProfilati }
     * 
     */
    public DatiProfilati createDatiProfilati() {
        return new DatiProfilati();
    }

    /**
     * Create an instance of {@link UtenteServizio }
     * 
     */
    public UtenteServizio createUtenteServizio() {
        return new UtenteServizio();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerNumeroIndividualeResponse }
     * 
     */
    public DettaglioFamigliaPerNumeroIndividualeResponse createDettaglioFamigliaPerNumeroIndividualeResponse() {
        return new DettaglioFamigliaPerNumeroIndividualeResponse();
    }

    /**
     * Create an instance of {@link DettaglioFamiglia }
     * 
     */
    public DettaglioFamiglia createDettaglioFamiglia() {
        return new DettaglioFamiglia();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerIdSoggettoResponse }
     * 
     */
    public DettaglioFamigliaPerIdSoggettoResponse createDettaglioFamigliaPerIdSoggettoResponse() {
        return new DettaglioFamigliaPerIdSoggettoResponse();
    }

    /**
     * Create an instance of {@link SystemException }
     * 
     */
    public SystemException createSystemException() {
        return new SystemException();
    }

    /**
     * Create an instance of {@link FamigliaNotFoundException }
     * 
     */
    public FamigliaNotFoundException createFamigliaNotFoundException() {
        return new FamigliaNotFoundException();
    }

    /**
     * Create an instance of {@link TooManyItemException }
     * 
     */
    public TooManyItemException createTooManyItemException() {
        return new TooManyItemException();
    }

    /**
     * Create an instance of {@link UnauthorizedException }
     * 
     */
    public UnauthorizedException createUnauthorizedException() {
        return new UnauthorizedException();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerCartaIdentita }
     * 
     */
    public DettaglioFamigliaPerCartaIdentita createDettaglioFamigliaPerCartaIdentita() {
        return new DettaglioFamigliaPerCartaIdentita();
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link VisuraFamigliaAllaDataPerIdSoggetto }
     * 
     */
    public VisuraFamigliaAllaDataPerIdSoggetto createVisuraFamigliaAllaDataPerIdSoggetto() {
        return new VisuraFamigliaAllaDataPerIdSoggetto();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerCodiceFiscaleResponse }
     * 
     */
    public DettaglioFamigliaPerCodiceFiscaleResponse createDettaglioFamigliaPerCodiceFiscaleResponse() {
        return new DettaglioFamigliaPerCodiceFiscaleResponse();
    }

    /**
     * Create an instance of {@link VisuraFamigliaAllaDataPerIdFamiglia }
     * 
     */
    public VisuraFamigliaAllaDataPerIdFamiglia createVisuraFamigliaAllaDataPerIdFamiglia() {
        return new VisuraFamigliaAllaDataPerIdFamiglia();
    }

    /**
     * Create an instance of {@link DettaglioMinimoFamigliePerID }
     * 
     */
    public DettaglioMinimoFamigliePerID createDettaglioMinimoFamigliePerID() {
        return new DettaglioMinimoFamigliePerID();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerCartaIdentitaResponse }
     * 
     */
    public DettaglioFamigliaPerCartaIdentitaResponse createDettaglioFamigliaPerCartaIdentitaResponse() {
        return new DettaglioFamigliaPerCartaIdentitaResponse();
    }

    /**
     * Create an instance of {@link DettaglioMinimoFamigliePerIDResponse }
     * 
     */
    public DettaglioMinimoFamigliePerIDResponse createDettaglioMinimoFamigliePerIDResponse() {
        return new DettaglioMinimoFamigliePerIDResponse();
    }

    /**
     * Create an instance of {@link DettaglioMinimoFamiglia }
     * 
     */
    public DettaglioMinimoFamiglia createDettaglioMinimoFamiglia() {
        return new DettaglioMinimoFamiglia();
    }

    /**
     * Create an instance of {@link VisuraFamigliaAllaDataPerIdFamigliaResponse }
     * 
     */
    public VisuraFamigliaAllaDataPerIdFamigliaResponse createVisuraFamigliaAllaDataPerIdFamigliaResponse() {
        return new VisuraFamigliaAllaDataPerIdFamigliaResponse();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaStorico }
     * 
     */
    public DettaglioFamigliaStorico createDettaglioFamigliaStorico() {
        return new DettaglioFamigliaStorico();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerID }
     * 
     */
    public DettaglioFamigliaPerID createDettaglioFamigliaPerID() {
        return new DettaglioFamigliaPerID();
    }

    /**
     * Create an instance of {@link VisuraFamiglieInCoabitazione }
     * 
     */
    public VisuraFamiglieInCoabitazione createVisuraFamiglieInCoabitazione() {
        return new VisuraFamiglieInCoabitazione();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerNumeroFamiglia }
     * 
     */
    public DettaglioFamigliaPerNumeroFamiglia createDettaglioFamigliaPerNumeroFamiglia() {
        return new DettaglioFamigliaPerNumeroFamiglia();
    }

    /**
     * Create an instance of {@link FormalException }
     * 
     */
    public FormalException createFormalException() {
        return new FormalException();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerNumeroIndividuale }
     * 
     */
    public DettaglioFamigliaPerNumeroIndividuale createDettaglioFamigliaPerNumeroIndividuale() {
        return new DettaglioFamigliaPerNumeroIndividuale();
    }

    /**
     * Create an instance of {@link TestataFamigliePerIDResponse }
     * 
     */
    public TestataFamigliePerIDResponse createTestataFamigliePerIDResponse() {
        return new TestataFamigliePerIDResponse();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerNumeroFamigliaResponse }
     * 
     */
    public DettaglioFamigliaPerNumeroFamigliaResponse createDettaglioFamigliaPerNumeroFamigliaResponse() {
        return new DettaglioFamigliaPerNumeroFamigliaResponse();
    }

    /**
     * Create an instance of {@link VisuraFamigliaAllaDataPerNumeroFamigliaResponse }
     * 
     */
    public VisuraFamigliaAllaDataPerNumeroFamigliaResponse createVisuraFamigliaAllaDataPerNumeroFamigliaResponse() {
        return new VisuraFamigliaAllaDataPerNumeroFamigliaResponse();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerCodiceFiscale }
     * 
     */
    public DettaglioFamigliaPerCodiceFiscale createDettaglioFamigliaPerCodiceFiscale() {
        return new DettaglioFamigliaPerCodiceFiscale();
    }

    /**
     * Create an instance of {@link VisuraFamiglieInCoabitazioneResponse }
     * 
     */
    public VisuraFamiglieInCoabitazioneResponse createVisuraFamiglieInCoabitazioneResponse() {
        return new VisuraFamiglieInCoabitazioneResponse();
    }

    /**
     * Create an instance of {@link VisuraFamigliaAllaDataPerIdSoggettoResponse }
     * 
     */
    public VisuraFamigliaAllaDataPerIdSoggettoResponse createVisuraFamigliaAllaDataPerIdSoggettoResponse() {
        return new VisuraFamigliaAllaDataPerIdSoggettoResponse();
    }

    /**
     * Create an instance of {@link DettaglioFamigliaPerIDResponse }
     * 
     */
    public DettaglioFamigliaPerIDResponse createDettaglioFamigliaPerIDResponse() {
        return new DettaglioFamigliaPerIDResponse();
    }

    /**
     * Create an instance of {@link TestataFamigliePerID }
     * 
     */
    public TestataFamigliePerID createTestataFamigliePerID() {
        return new TestataFamigliePerID();
    }

    /**
     * Create an instance of {@link VisuraFamigliaAllaDataPerNumeroFamiglia }
     * 
     */
    public VisuraFamigliaAllaDataPerNumeroFamiglia createVisuraFamigliaAllaDataPerNumeroFamiglia() {
        return new VisuraFamigliaAllaDataPerNumeroFamiglia();
    }

    /**
     * Create an instance of {@link IndirizzoEsterno }
     * 
     */
    public IndirizzoEsterno createIndirizzoEsterno() {
        return new IndirizzoEsterno();
    }

    /**
     * Create an instance of {@link VisuraSoggetto }
     * 
     */
    public VisuraSoggetto createVisuraSoggetto() {
        return new VisuraSoggetto();
    }

    /**
     * Create an instance of {@link Identita }
     * 
     */
    public Identita createIdentita() {
        return new Identita();
    }

    /**
     * Create an instance of {@link Coniuge }
     * 
     */
    public Coniuge createConiuge() {
        return new Coniuge();
    }

    /**
     * Create an instance of {@link Generalita }
     * 
     */
    public Generalita createGeneralita() {
        return new Generalita();
    }

    /**
     * Create an instance of {@link StatoSoggetto }
     * 
     */
    public StatoSoggetto createStatoSoggetto() {
        return new StatoSoggetto();
    }

    /**
     * Create an instance of {@link DatiAIRE }
     * 
     */
    public DatiAIRE createDatiAIRE() {
        return new DatiAIRE();
    }

    /**
     * Create an instance of {@link CodiceFiscale }
     * 
     */
    public CodiceFiscale createCodiceFiscale() {
        return new CodiceFiscale();
    }

    /**
     * Create an instance of {@link ArrayOfComponenteFamigliaStorico }
     * 
     */
    public ArrayOfComponenteFamigliaStorico createArrayOfComponenteFamigliaStorico() {
        return new ArrayOfComponenteFamigliaStorico();
    }

    /**
     * Create an instance of {@link Genitore }
     * 
     */
    public Genitore createGenitore() {
        return new Genitore();
    }

    /**
     * Create an instance of {@link EventoEmigrazione }
     * 
     */
    public EventoEmigrazione createEventoEmigrazione() {
        return new EventoEmigrazione();
    }

    /**
     * Create an instance of {@link Cittadinanza }
     * 
     */
    public Cittadinanza createCittadinanza() {
        return new Cittadinanza();
    }

    /**
     * Create an instance of {@link ComponenteFamigliaStorico }
     * 
     */
    public ComponenteFamigliaStorico createComponenteFamigliaStorico() {
        return new ComponenteFamigliaStorico();
    }

    /**
     * Create an instance of {@link DettaglioMinimoSoggetto }
     * 
     */
    public DettaglioMinimoSoggetto createDettaglioMinimoSoggetto() {
        return new DettaglioMinimoSoggetto();
    }

    /**
     * Create an instance of {@link StatoCivile }
     * 
     */
    public StatoCivile createStatoCivile() {
        return new StatoCivile();
    }

    /**
     * Create an instance of {@link SoggettoFamiglia }
     * 
     */
    public SoggettoFamiglia createSoggettoFamiglia() {
        return new SoggettoFamiglia();
    }

    /**
     * Create an instance of {@link DettaglioEventoEmigrazione }
     * 
     */
    public DettaglioEventoEmigrazione createDettaglioEventoEmigrazione() {
        return new DettaglioEventoEmigrazione();
    }

    /**
     * Create an instance of {@link Luogo }
     * 
     */
    public Luogo createLuogo() {
        return new Luogo();
    }

    /**
     * Create an instance of {@link TestataFamiglia }
     * 
     */
    public TestataFamiglia createTestataFamiglia() {
        return new TestataFamiglia();
    }

    /**
     * Create an instance of {@link PraticaAnagrafe }
     * 
     */
    public PraticaAnagrafe createPraticaAnagrafe() {
        return new PraticaAnagrafe();
    }

    /**
     * Create an instance of {@link ArrayOfGenitore }
     * 
     */
    public ArrayOfGenitore createArrayOfGenitore() {
        return new ArrayOfGenitore();
    }

    /**
     * Create an instance of {@link Soggetto }
     * 
     */
    public Soggetto createSoggetto() {
        return new Soggetto();
    }

    /**
     * Create an instance of {@link PraticaEmigrazione }
     * 
     */
    public PraticaEmigrazione createPraticaEmigrazione() {
        return new PraticaEmigrazione();
    }

    /**
     * Create an instance of {@link IndirizzoInterno }
     * 
     */
    public IndirizzoInterno createIndirizzoInterno() {
        return new IndirizzoInterno();
    }

    /**
     * Create an instance of {@link Documento }
     * 
     */
    public Documento createDocumento() {
        return new Documento();
    }

    /**
     * Create an instance of {@link ArrayOfDettaglioMinimoSoggetto }
     * 
     */
    public ArrayOfDettaglioMinimoSoggetto createArrayOfDettaglioMinimoSoggetto() {
        return new ArrayOfDettaglioMinimoSoggetto();
    }

    /**
     * Create an instance of {@link BloccoCertificabilitaANA }
     * 
     */
    public BloccoCertificabilitaANA createBloccoCertificabilitaANA() {
        return new BloccoCertificabilitaANA();
    }

    /**
     * Create an instance of {@link CSIException }
     * 
     */
    public CSIException createCSIException() {
        return new CSIException();
    }

    /**
     * Create an instance of {@link SystemException2 }
     * 
     */
    public SystemException2 createSystemException2() {
        return new SystemException2();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SrvVisuraFamiglia", name = "fault1")
    public JAXBElement<ServiceException> createFault1(ServiceException value) {
        return new JAXBElement<ServiceException>(_Fault1_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamigliaNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SrvVisuraFamiglia", name = "fault3")
    public JAXBElement<FamigliaNotFoundException> createFault3(FamigliaNotFoundException value) {
        return new JAXBElement<FamigliaNotFoundException>(_Fault3_QNAME, FamigliaNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SrvVisuraFamiglia", name = "fault2")
    public JAXBElement<SystemException> createFault2(SystemException value) {
        return new JAXBElement<SystemException>(_Fault2_QNAME, SystemException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnauthorizedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SrvVisuraFamiglia", name = "fault5")
    public JAXBElement<UnauthorizedException> createFault5(UnauthorizedException value) {
        return new JAXBElement<UnauthorizedException>(_Fault5_QNAME, UnauthorizedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TooManyItemException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SrvVisuraFamiglia", name = "fault4")
    public JAXBElement<TooManyItemException> createFault4(TooManyItemException value) {
        return new JAXBElement<TooManyItemException>(_Fault4_QNAME, TooManyItemException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormalException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SrvVisuraFamiglia", name = "fault")
    public JAXBElement<FormalException> createFault(FormalException value) {
        return new JAXBElement<FormalException>(_Fault_QNAME, FormalException.class, null, value);
    }

}
