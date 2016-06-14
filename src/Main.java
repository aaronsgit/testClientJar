import solutions.legatus.mservice.mscc.client.Bean.impl.MsccBeanAdapter;
import solutions.legatus.mservice.mscc.client.Bean.impl.MsccCollectionObjectAcq;
import solutions.legatus.mservice.mscc.client.Service.impl.CommDialogService;

public class Main {

    public static void main(String[] args) {

        CommDialogService service = new CommDialogService( "http://192.168.27.19", "8100", "AppName", "AppKey", "AppSecret", "Accesstoken" );



        MsccBeanAdapter.CollectionObject entity = MsccBeanAdapter.CollectionObject.getBuilder()
                .ID( new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott214", "user114", "serious", 1 ) )
                .AcqUserService( MsccCollectionObjectAcq.SERVICE )
                .build();

        MsccBeanAdapter.CollectionObject objectsData = service.getObjectsByKey( entity.getID() );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + objectsData.toString() );
        System.out.println( "-------------------------------");


    }
}
