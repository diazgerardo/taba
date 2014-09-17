package ar.com.scriptorum.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.com.scriptorum.beans.Carpooler;
import ar.com.scriptorum.beans.Group;
import ar.com.scriptorum.beans.GroupMember;
import ar.com.scriptorum.beans.Itinerario;
import ar.com.scriptorum.beans.Keywords;
import ar.com.scriptorum.beans.PMethod;
import ar.com.scriptorum.beans.PName;
import ar.com.scriptorum.beans.PUnit;
import ar.com.scriptorum.beans.Vehiculo;
import ar.com.scriptorum.beans.Viaje;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appContext.xml")
public class DaoTest {

    @Autowired
    ViajeDao viajeDao;
    @Autowired
    CarpoolerDao carpoolerDao;
    @Autowired
    ItinerarioDao itinerarioDao;
    @Autowired
    GroupDao groupDao;
    @Autowired
    VehiculoDao vehiculoDao;
    @Autowired
    PUnitDao punitDao;
    @Autowired
    PNameDao pnameDao;

    String carpooler1 = "aaa";
    String carpooler2 = "bbb";
    String megane = "BXG983";
    String itinerario = "some place";
    String grupo1 = "testable";

    @Before
    @Transactional
    public void createCooperativeEntities() {

        Carpooler carpooler = new Carpooler();
        carpooler.setNombre(carpooler1);
        carpooler.setDni("123456");
        carpooler.setTelefono("456 789");
        carpoolerDao.save(carpooler);

        carpooler = new Carpooler();
        carpooler.setNombre(carpooler2);
        carpooler.setDni("765432");
        carpooler.setTelefono("987 654");
        carpoolerDao.save(carpooler);

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAlta(new Date());
        vehiculo.setPatente(megane);
        vehiculo.setPlazas(4);
        vehiculoDao.save(vehiculo);

    }

    @Test
    @Transactional
    public void createGroupAndGroupMembers() {
        Group group = new Group();
        Set<GroupMember> members = new HashSet<GroupMember>();
        group.setCreacion(new Date());
        group.setNombre(grupo1);
        group.setGroupMembers(members);

        Carpooler c1 = carpoolerDao.findUnique("nombre", carpooler1);
        Carpooler c2 = carpoolerDao.findUnique("nombre", carpooler2);
        GroupMember gm1 = new GroupMember();
        gm1.setCarpooler(c1);
        gm1.setGroup(group);
        group.getGroupMembers().add(gm1);

        GroupMember gm2 = new GroupMember();
        gm2.setCarpooler(c2);
        gm2.setGroup(group);
        group.getGroupMembers().add(gm2);

        groupDao.save(group);

        Itinerario it = new Itinerario();
        it.setDescripcion(itinerario);
        it.setGoogleMapId(25);

        itinerarioDao.save(it);

    }

    @Test
    @Transactional
    public void createItinerarios() {

        Itinerario somewhere = itinerarioDao.findUnique("descripcion", itinerario);
        Group group = groupDao.findUnique("nombre", grupo1);
        Vehiculo vehiculo = vehiculoDao.findUnique("patente", megane);
        for (int v = 1; v < 10; v++) {
            Viaje viaje = new Viaje();
            viaje.setItinerario(somewhere);
            viaje.setGroup(group);
            viaje.setVehiculo(vehiculo);
            viaje.setInicio(new Date());
            viaje.setFin(new Date());
            viaje.setCerrado(Boolean.TRUE);
            viajeDao.save(viaje);
        }
    }

    @Test
    @Transactional
    public void createPunit() {
        // TODO move into factory!!
        
        PUnit punit = new PUnit();
        PName pname = new PName();
        pname.setCreation("creation");
        punit.setPName(pname);
        punit.setMd5("md5");
        Set<PUnit>punits = new HashSet<PUnit>();
        punits.add(punit);
        pname.setPunits(punits);
        
        PMethod method = new PMethod();
        method.setMd5("md5");
        method.setpUnit(punit);
        Keywords keywords = new Keywords();
        Set<Keywords>keywordss = new HashSet<Keywords>();
        keywordss.add(keywords);
        method.setKeywords(keywordss);
        Set<PMethod>methods = new HashSet<PMethod>();
        methods.add(method);
        punit.setMethods(methods);
        pnameDao.save(pname);
        punitDao.save(punit);
        Long id = punit.getId();
        System.out.println(id);
        punitDao.delete(punit);
    }

}
