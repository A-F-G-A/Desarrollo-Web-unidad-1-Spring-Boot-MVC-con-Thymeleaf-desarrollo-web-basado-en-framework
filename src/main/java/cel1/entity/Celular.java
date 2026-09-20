package cel1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "celulares")
public class Celular {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "imei")
    private String imei;

    @Column(name = "pulgadas")
    private String pulgadas;

    @Column(name = "megapixeles")
    private String megapixeles;

    @Column(name = "ram")
    private String ram;

    @Column(name = "almacenamiento_principal")
    private String almacenamientoPrincipal;

    @Column(name = "almacenamiento_secundario")
    private String almacenamientoSecundario;

    @Column(name = "sistema_operativo")
    private String sistemaOperativo;

    @Column(name = "operador")
    private String operador;

    @Column(name = "tecnologia_banda")
    private String tecnologiaBanda;

    @Column(name = "wifi")
    private String wifi;

    @Column(name = "bluetooth")
    private String bluetooth;

    @Column(name = "camaras")
    private String camaras;

    @Column(name = "marca_cpu")
    private String marcaCpu;

    @Column(name = "velocidad_cpu")
    private String velocidadCpu;

    @Column(name = "nfc")
    private String nfc;

    @Column(name = "huella")
    private String huella;

    @Column(name = "ir")
    private String ir;

    @Column(name = "resiste_agua")
    private String resisteAgua;

    @Column(name = "cantidad_sim")
    private String cantidadSim;

    public Celular() {
    }

    public Celular(String id, String marca, String imei, String pulgadas, String megapixeles, String ram,
                   String almacenamientoPrincipal, String almacenamientoSecundario, String sistemaOperativo,
                   String operador, String tecnologiaBanda, String wifi, String bluetooth, String camaras,
                   String marcaCpu, String velocidadCpu, String nfc, String huella, String ir, String resisteAgua,
                   String cantidadSim) {
        this.id = id;
        this.marca = marca;
        this.imei = imei;
        this.pulgadas = pulgadas;
        this.megapixeles = megapixeles;
        this.ram = ram;
        this.almacenamientoPrincipal = almacenamientoPrincipal;
        this.almacenamientoSecundario = almacenamientoSecundario;
        this.sistemaOperativo = sistemaOperativo;
        this.operador = operador;
        this.tecnologiaBanda = tecnologiaBanda;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
        this.camaras = camaras;
        this.marcaCpu = marcaCpu;
        this.velocidadCpu = velocidadCpu;
        this.nfc = nfc;
        this.huella = huella;
        this.ir = ir;
        this.resisteAgua = resisteAgua;
        this.cantidadSim = cantidadSim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getMegapixeles() {
        return megapixeles;
    }

    public void setMegapixeles(String megapixeles) {
        this.megapixeles = megapixeles;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAlmacenamientoPrincipal() {
        return almacenamientoPrincipal;
    }

    public void setAlmacenamientoPrincipal(String almacenamientoPrincipal) {
        this.almacenamientoPrincipal = almacenamientoPrincipal;
    }

    public String getAlmacenamientoSecundario() {
        return almacenamientoSecundario;
    }

    public void setAlmacenamientoSecundario(String almacenamientoSecundario) {
        this.almacenamientoSecundario = almacenamientoSecundario;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getTecnologiaBanda() {
        return tecnologiaBanda;
    }

    public void setTecnologiaBanda(String tecnologiaBanda) {
        this.tecnologiaBanda = tecnologiaBanda;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getCamaras() {
        return camaras;
    }

    public void setCamaras(String camaras) {
        this.camaras = camaras;
    }

    public String getMarcaCpu() {
        return marcaCpu;
    }

    public void setMarcaCpu(String marcaCpu) {
        this.marcaCpu = marcaCpu;
    }

    public String getVelocidadCpu() {
        return velocidadCpu;
    }

    public void setVelocidadCpu(String velocidadCpu) {
        this.velocidadCpu = velocidadCpu;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getResisteAgua() {
        return resisteAgua;
    }

    public void setResisteAgua(String resisteAgua) {
        this.resisteAgua = resisteAgua;
    }

    public String getCantidadSim() {
        return cantidadSim;
    }

    public void setCantidadSim(String cantidadSim) {
        this.cantidadSim = cantidadSim;
    }
}
