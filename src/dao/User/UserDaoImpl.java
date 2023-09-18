package dao.User;
import model.Book;
import model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl { //to make the CRUD of interface
    private final Map<Integer, User> usermap = new HashMap<>(); //map dos usuarios
    private int proximoID=0;
    private int getProximoID() {
        /**
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.proximoID++; //Retorna ID para o objeto atual e define o próximo ID
    }
    public User creat(User user){ //criando um usuario e colocando no map
        user.setId(getProximoID()); //aq vai adicionar o id automaticamente no atributo id
        usermap.put(user.getId(), user);
        return user;}
    public List<User> findAll() { //retorna uma lista de livros
        return new ArrayList<>(usermap.values());}
    public User findById(int id) {  //retorna um livro pelo Id
        return usermap.get(id);}
    public User update(User user) {
        usermap.put(user.getId(), user);
        return null;}
    public void delete(User user) {
        int id = user.getId();
        usermap.remove(id);}
}
