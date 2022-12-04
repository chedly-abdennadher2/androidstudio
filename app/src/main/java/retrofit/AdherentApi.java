package retrofit;
import java.util.List;
import model.Adherent;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface AdherentApi {
    @GET("/adherent/adherents")
    public Call <List<Adherent>> adherents ();
    @POST("/adherent/add")
    Call<Adherent> save (@Body Adherent adherent);


}
