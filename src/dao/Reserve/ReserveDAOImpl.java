package dao.Reserve;

import model.Reserve;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReserveDAOImpl implements ReserveDAO {
    private final Map<Long, Reserve> reserveMap = new HashMap<>();

    @Override
    public Reserve creat(Reserve reserve) {
        long id = reserve.getId();
        reserveMap.put(id, reserve);
        return reserve;
    }

    @Override
    public List<Reserve> findAll() {
        return new ArrayList<>(reserveMap.values());
    }

    @Override
    public Reserve findById(long id) {
        return reserveMap.get(id);
    }

    @Override
    public Reserve update(Reserve reserve) {
        reserveMap.put(reserve.getId(), reserve);
        return reserve;
    }

    @Override
    public void delete(Reserve reserve) {
        reserveMap.remove(reserve.getId());
    }

    @Override
    public void deleteAll() {
        reserveMap.clear();
    }
}
