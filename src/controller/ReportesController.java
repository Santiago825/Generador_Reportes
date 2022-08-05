package controller;



import java.sql.SQLException;
import java.util.List;
import model.dao.LiderDao;
import model.dao.MaterialesDao;
import model.dao.ProyectoDao;
import model.vo.LiderVo;
import model.vo.MaterialesVo;
import model.vo.ProyectoVo;



public class ReportesController {
    private final LiderDao liderDao;
    private final ProyectoDao proyectoDao;
    private final MaterialesDao materialesDao;


    public ReportesController() {
        this.liderDao = new LiderDao();
        this.proyectoDao = new ProyectoDao();
        this.materialesDao = new MaterialesDao();
    }

    public List<LiderVo> findAllLider() throws SQLException {
        return liderDao.findAll();
    }
    public List<ProyectoVo> findAllProyecto() throws SQLException {
        return proyectoDao.findAll();
    }
    public List<MaterialesVo> findAllMateriales() throws SQLException {
        return materialesDao.findAll();
    }

    

}
