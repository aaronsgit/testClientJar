
import org.junit.Before;
import org.junit.Test;
import solutions.legatus.mservice.mscc.client.Bean.impl.*;
import solutions.legatus.mservice.mscc.client.Service.impl.CommDialogService;
import solutions.legatus.mservice.mscc.client.Utils.BeanUtils;
import solutions.legatus.mservice.mscc.client.Utils.MsccConstants;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahou on 5/17/2016.
 */
public class DialogServiceTest {

    private CommDialogService service;

    @Before
    public void setup() {
         service  =  new CommDialogService( "http://localhost", "8100", "AppName", "AppKey", "AppSecret", "Accesstoken" );

        //System.out.println( "service service" + service  );
    }


    @Test
    public void Collection_add_test() {

        MsccBeanAdapter.Collection entity = MsccBeanAdapter.Collection.getBuilder()
                .ID( new MsccBeanAdapter.Collection.ID( "legat120", "scott121", "", "night" ) )
                .Account( "123456789")
                .DialogShare(MsccCollectionDialogShare.ORGOWNER )
                .DialogType(MsccCollectionDialogType.ALLTYPE )
                .Folder( "piano" )
                .OrganizationCreator( "legat188")
                .build();

        String result = service.makeNewCollection( entity );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Object_add_test() {

        MsccBeanAdapter.CollectionObject entity = MsccBeanAdapter.CollectionObject.getBuilder()
                .ID( new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott121", "", "night", null ) )
                .AcqUserService( MsccCollectionObjectAcq.SERVICE )
                .Handle( "D:\\DropBox\\Dropbox (Legatus)\\SIAT30\\IRPRenewalInfo.pdf" )
                .Supersedes( "ooo" )
                .build();

        String result = service.addNewObjectFromFileHandle( entity );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void FolderContents_add_test() {

        MsccBeanAdapter.FolderContents.ID contentsID = new  MsccBeanAdapter.FolderContents.ID( "legat120", "sedona", "snow", "street", "legat120", "scott121", "", "night", 1  );

        MsccBeanAdapter.FolderContents entity = MsccBeanAdapter.FolderContents.getBuilder().ID( contentsID ).build();

        String result  = service.addCollectionToFolder( entity );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }


    @Test
    public void FolderContents_remove_test() {

        MsccBeanAdapter.FolderContents.ID contentsID = new  MsccBeanAdapter.FolderContents.ID( "legat120", "sedona", "snow", "street", "legat120", "scott121", "", "night", 1  );

        String result  = service.removeCollctionFromFolder( contentsID );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Folder_add_test() {

        MsccBeanAdapter.Collection entity = MsccBeanAdapter.Collection.getBuilder()
                .ID( new MsccBeanAdapter.Collection.ID( "legat110", "scott111", "", "night" ) )
                .Account( "123456789")
                .DialogShare(MsccCollectionDialogShare.ORGOWNER )
                .DialogType(MsccCollectionDialogType.ALLTYPE )
                .Folder( "makeup" )
                .OrganizationCreator( "legat188")
                .build();

        String result = service.addFolder( entity );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Folder_remove_test() {

        MsccBeanAdapter.Folder entity = MsccBeanAdapter.Folder.getBuilder()
                .ID( new MsccBeanAdapter.Folder.ID( "legat110", "scott111", "", "makeup" ) )
                .build();

        String result = service.deleteFolder ( entity.getID() );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Organization_add_test() {

        MsccBeanAdapter.Organization organization = MsccBeanAdapter.Organization.getBuilder()
                .ID( new MsccBeanAdapter.Organization.ID( "legat001" ))
                .Country( MsccOrganizationCountry.US )
                .GovLevel(MsccOrganizationLevel.NATIONAL )
                .Name( "Legatus Corp. scottsdale branch")
                .Type(MsccOrganizationType.JURMCS )
                .build();

        String result  = service.addOrganization( organization );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }



    @Test
    public void Organization_update_test() {

        MsccBeanAdapter.Organization entity = MsccBeanAdapter.Organization.getBuilder()
                .ID( new MsccBeanAdapter.Organization.ID( "legat001" ))
                .Country( MsccOrganizationCountry.US )
                .GovLevel( MsccOrganizationLevel.JURISDICTION )
                .Name( "Legatus Corp 32" )
                .Type( MsccOrganizationType.REGISTRANT )
                .build();


        MsccBeanAdapter.Organization updated = MsccBeanAdapter.Organization.getBuilder()
                .ID( new MsccBeanAdapter.Organization.ID( "legat001" ))
                .Country( MsccOrganizationCountry.US )
                .GovLevel( MsccOrganizationLevel.JURISDICTION )
                .Name( "Legatus Corp 588" )
                .Type( MsccOrganizationType.REGISTRANT )
                .build();


        String result  = service.updateOrganization( entity.getID(), updated );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }


    @Test
    public void Organization_remove_test() {

        MsccBeanAdapter.Organization entity = MsccBeanAdapter.Organization.getBuilder()
                .ID( new MsccBeanAdapter.Organization.ID( "legat588" ))
                .build();

        String result  = service.removeOrganization( entity.getID() );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }




    @Test
    public void Office_add_test() {

        MsccBeanAdapter.Office entity = MsccBeanAdapter.Office.getBuilder()
                .ID(  new MsccBeanAdapter.Office.ID("legat120", "scott099") )
                .Address1( "7580 E gray st 123 ")
                .Address2("#102123")
                .City( "Scottsdale123")
                .Jurisdiction( "ADOT123")
                .MainTele( "480-1234567123")
                .Desc("headquater123")
                .Postal("85260123")
                .Website("www.xxxx123.com")
                .build();

        String result  = service.addOffice( entity  );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Office_update_test() {

        MsccBeanAdapter.Office entity = MsccBeanAdapter.Office.getBuilder()
                .ID(  new MsccBeanAdapter.Office.ID("legat120", "scott099") )
                .Address1( "7580 E gray st 123 ")
                .Address2("#102123")
                .City( "Scottsdale123")
                .Jurisdiction( "ADOT123")
                .MainTele( "480-1234567123")
                .Desc("headquater123")
                .Postal("85260123")
                .Website("www.xxxx123.com")
                .build();

        MsccBeanAdapter.Office updated = MsccBeanAdapter.Office.getBuilder()
                .ID(  new MsccBeanAdapter.Office.ID("legat120", "scott099") )
                .Address1( "75801 E gray st 123 ")
                .Address2("#1021231")
                .City( "Scottsdale123")
                .Jurisdiction( "ADOT123")
                .MainTele( "480-1234567123")
                .Desc("headquater123")
                .Postal("85260123")
                .Website("www.xxxx1234.com")
                .build();

        String result  = service.updateOffice( entity.getID(), updated  );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Office_remove_test() {

        MsccBeanAdapter.Office entity = MsccBeanAdapter.Office.getBuilder()
                .ID(  new MsccBeanAdapter.Office.ID("legat120", "scott099") )
                .Address1( "7580 E gray st 123 ")
                .Address2("#102123")
                .City( "Scottsdale123")
                .Jurisdiction( "ADOT123")
                .MainTele( "480-1234567123")
                .Desc("headquater123")
                .Postal("85260123")
                .Website("www.xxxx123.com")
                .build();


        String result  = service.removeOffice( entity.getID()  );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void user_add_test() {

        MsccBeanAdapter.User entity = MsccBeanAdapter.User.getBuilder()
                .ID(  new MsccBeanAdapter.User.ID( "legat120", "parker"  ) )
                .Name( "spiderman")
                .PersonalTitle( MsccUserPersonalTitle.MR )
                .TeleDaytime( "4151234567")
                .TeleOffhours( "4801234567")
                .Timezone( "us-az")
                .Title( "super spider")
                .Credential( "spider")
                .Email( "super@spider.com")
                .build();

        String result  = service.addUser( entity  );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void user_update_test() {

        MsccBeanAdapter.User entity = MsccBeanAdapter.User.getBuilder()
                .ID(  new MsccBeanAdapter.User.ID( "legat120", "parker"  ) )
                .Name( "spiderman")
                .PersonalTitle( MsccUserPersonalTitle.MR )
                .TeleDaytime( "4151234567")
                .TeleOffhours( "4801234567")
                .Timezone( "us-az")
                .Title( "super spider")
                .Credential( "spider")
                .Email( "super@spider.com")
                .build();

        MsccBeanAdapter.User updated = MsccBeanAdapter.User.getBuilder()
                .ID(  new MsccBeanAdapter.User.ID( "legat120", "parker"  ) )
                .Name( "spiderman")
                .PersonalTitle( MsccUserPersonalTitle.MR )
                .TeleDaytime( "4151234567")
                .TeleOffhours( "4801234567")
                .Timezone( "us-ny")
                .Title( "super spider")
                .Credential( "spider")
                .Email( "super@spider007.com")
                .build();

        String result  = service.updateUser( entity.getID(), updated  );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void User_remove_test() {


        MsccBeanAdapter.User entity = MsccBeanAdapter.User.getBuilder()
                .ID(  new MsccBeanAdapter.User.ID( "legat120", "parker"  ) )
                .Name( "spiderman")
                .PersonalTitle( MsccUserPersonalTitle.MR )
                .TeleDaytime( "4151234567")
                .TeleOffhours( "4801234567")
                .Timezone( "us-az")
                .Title( "super spider")
                .Credential( "spider")
                .Email( "super@spider.com")
                .build();

        String result  = service.removeUser( entity.getID()  );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }

    @Test
    public void userOffice_add_test() {

        MsccBeanAdapter.UserOffice entity = MsccBeanAdapter.UserOffice.getBuilder()
                                                .ID(  new MsccBeanAdapter.UserOffice.ID( "legat120", "scott111", "parker" ) )
                                                .OfficeRole( "shrek")
                                                .OrganizationFacilitator( "blarock")
                                                .UserFacilitator( "heropanda")
                                                .build();


        String result  = service.userToOffice( entity );


        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }


    @Test
    public void permission_add_test() {
//
//        MsccBeanAdapter.SentTo.ID msccSentToID = new MsccBeanAdapter.SentTo.ID( "legat120", "scott214", "user114", "serious", 14, "legat120", "scott129", "ironman", null );
//
//        Timestamp ts = Timestamp.from( Instant.parse("2020-10-23T10:12:35Z") );
//
//        MsccBeanAdapter.SentTo entity  = MsccBeanAdapter.SentTo.getBuilder()
//                                                    .ID( msccSentToID )
//                                                    .AccessRightSentTo( MsccObjectSentToRight.DISTRIBUTE  )
//                                                    .ActionRequestedSentTo( MsccObjectSentToAction.NONE )
//                                                    .ActionTimeRequired( ts )
//                                                    .ActionSenderPriority( MsccObjectSentToPriority.LEVEL3 )
//                                                    .ActionStatusSentTo( "status")
//                                                    .ActionDescSentTo( "desc")
//                                                    .OrganizationSender( "legat120")
//                                                    .OfficeSender( "scott214")
//                                                    .UserSender( "user114")
//                                                    .build();
//
//        String result  = service.addPermission(  entity );
//
//        System.out.println( "-------------------------------");
//        System.out.println( "The result is: " + result );
//        System.out.println( "-------------------------------");

    }




    @Test
    public void Permission_remove_test() {

        MsccBeanAdapter.SentTo.ID msccSentToID = new MsccBeanAdapter.SentTo.ID( "legat120", "scott214", "user114", "serious", 14, "legat120", "scott129", "ironman", BeanUtils.GetUTCTimestamp( "2016-05-21T16:56:53.655Z" ));

        String result = service.removePermission( msccSentToID );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }




    @Test
    public void Action_add_test() {

        MsccBeanAdapter.SentTo.ID msccSentToID = new MsccBeanAdapter.SentTo.ID( "legat120", "scott214", "user114", "serious", 12, "legat120", "scott129", "ironman", null );

//        Timestamp ts = Timestamp.from( Instant.parse("2020-10-23T10:12:35Z") );
//
//        MsccBeanAdapter.SentTo entity  = MsccBeanAdapter.SentTo.getBuilder()
//                .ID( msccSentToID )
//                .AccessRightSentTo( MsccObjectSentToRight.ZERO  )
//                .ActionRequestedSentTo( MsccObjectSentToAction.RESUBMIT )
//                .ActionTimeRequired( ts )
//                .ActionSenderPriority( MsccObjectSentToPriority.LEVEL3 )
//                .ActionStatusSentTo( "status")
//                .ActionDescSentTo( "desc")
//                .OrganizationSender( "legat120")
//                .OfficeSender( "scott214")
//                .UserSender( "user114")
//                .build();
//
//
//        String result = service.sendAction( entity );
//
//        System.out.println( "-------------------------------");
//        System.out.println( "The result is: " + result );
//        System.out.println( "-------------------------------");

    }



    @Test
    public void Action_remove_test() {

        MsccBeanAdapter.SentTo.ID msccSentToID = new MsccBeanAdapter.SentTo.ID( "legat120", "scott214", "user114", "serious", 12, "legat120", "scott129", "ironman", BeanUtils.GetUTCTimestamp( "2016-05-21T17:09:18.052Z" ));

        String result = service.removePermission( msccSentToID );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void EmailObjects_test() throws Exception {

        // Objects
        List<MsccBeanAdapter.CollectionObject.ID> ids = new ArrayList<MsccBeanAdapter.CollectionObject.ID>();
        MsccBeanAdapter.CollectionObject.ID id1 = new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott129", "ironman", "sky", 1 );
        MsccBeanAdapter.CollectionObject.ID id2 = new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott214", "user114", "serious", 3 );
        MsccBeanAdapter.CollectionObject.ID id3 = new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott214", "user114", "serious", 15 );

        ids.add( id1 );
        ids.add( id2 );
        ids.add( id3 );

        //Action
        List<String> acts = new ArrayList<String>();
        acts.add( "INFORMATION");
        acts.add( "SUBMIT");
        acts.add( "APPROVE");


        MsccBeanAdapter.EmailFact emailFact = new MsccBeanAdapter.EmailFact();

        emailFact.setOrganizationSender( "legat120");
        emailFact.setOfficeSender( "scott128");
        emailFact.setUserSender( "aaron");
        emailFact.setEmailSender( "ahou@legatus.solutions"  );

        emailFact.setOrganizationReceiver( "legat999");
        emailFact.setOfficeReceiver( "scott999");
        emailFact.setUserReceiver( "Brad");
        emailFact.setEmailReceiver( "ahou@legatus.solutions"  );

        emailFact.setObjectIDSet( ids );

        emailFact.setProcess( "EMAIL," );
        emailFact.setSubject( "This is test subject");
        emailFact.setActionRequested( acts );

        String result  = service.emailObjects( emailFact );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }

    @Test
    public void Collection_update_test() {

        MsccBeanAdapter.Collection entity = MsccBeanAdapter.Collection.getBuilder()

                .ID( new MsccBeanAdapter.Collection.ID( "legat120", "scott124", "superman", "cloud" ) )
                .Account( "123456789")
                .DialogShare(MsccCollectionDialogShare.ORGOWNER )
                .DialogType(MsccCollectionDialogType.ALLTYPE )
                .Folder( "piano" )
                .OrganizationCreator( "legat188")
                .build();

        MsccBeanAdapter.Collection updated = MsccBeanAdapter.Collection.getBuilder()

                .ID( new MsccBeanAdapter.Collection.ID( "legat120", "scott124", "superman", "cloud" ) )
                .Account( "987654321")
                .DialogShare(MsccCollectionDialogShare.ORGOWNER )
                .DialogType(MsccCollectionDialogType.ALLTYPE )
                //.Folder( "piano" )
                //.OrganizationCreator( "legat188")
                .build();

        String result  = service.updateCollectionName( entity.getID(), updated );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }



    @Test
    public void Meta_add_test() {


        MsccBeanAdapter.CollectionObject.ID objectID =  new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott214", "user114", "serious", 15  );

        MsccBeanAdapter.Meta.ID metaID = new MsccBeanAdapter.Meta.ID(  "legat120", "scott214", "user114", "serious", 15, "tempreture", "cold", 0, null  );

        MsccBeanAdapter.Meta entity = MsccBeanAdapter.Meta.getBuilder()
                .ID( metaID )
                .OrganizationMeta( "legat120" )
                .OfficeMeta( "scott128" )
                .UserMeta( "ironman" )
                .build();

        String result  = service.addMeta( entity );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");

    }


    @Test
    public void Meta_update_test() {

        MsccBeanAdapter.CollectionObject.ID objectID =  new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott214", "user114", "serious", 15  );

        MsccBeanAdapter.Meta.ID metaID = new MsccBeanAdapter.Meta.ID( "legat120", "scott214", "user114", "serious", 15, "noise", "loud", 0, null  );

        MsccBeanAdapter.Meta entity = MsccBeanAdapter.Meta.getBuilder()
                .ID( metaID )
                .OrganizationMeta( "legat120" )
                .OfficeMeta( "scott128" )
                .UserMeta( "ironman" )
                .build();


        MsccBeanAdapter.Meta.ID metaID1 = new MsccBeanAdapter.Meta.ID(  "legat120", "scott214", "user114", "serious", 15, "noise", "low", 0, null  );

        MsccBeanAdapter.Meta updated = MsccBeanAdapter.Meta.getBuilder()
                .ID( metaID1 )
                .OrganizationMeta( "legat120" )
                .OfficeMeta( "scott128" )
                .UserMeta( "ironman" )
                .build();

        String result  = service.updateObject( entity.getID(), updated );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + result );
        System.out.println( "-------------------------------");


    }



    @Test
    public void Meta_searchObjectsByMetaData_test() throws Exception {

        MsccBeanAdapter.SearchTerm t1 = new MsccBeanAdapter.SearchTerm(MsccConstants.MSCC_SEARCH_META_TYPE, "noise");
        MsccBeanAdapter.SearchTerm t2 = new MsccBeanAdapter.SearchTerm(MsccConstants.MSCC_SEARCH_META_CHVALUE, "low");

        MsccBeanAdapter.QueryCriteria q = new MsccBeanAdapter.QueryCriteria();
        q.addFuzzyQuery(t1);
        q.addFuzzyQuery(t2);

        List<String> orderBy = new ArrayList<String>();
        orderBy.add( "SentTs" );


        List<MsccBeanAdapter.CollectionObject.ID> objectsByMetaData = service.searchObjectsByMetaData(q );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + objectsByMetaData );
        System.out.println( "-------------------------------");

    }



    @Test
    public void Object_getObjectsByKey_test() {

        MsccBeanAdapter.CollectionObject entity = MsccBeanAdapter.CollectionObject.getBuilder()
                .ID( new MsccBeanAdapter.CollectionObject.ID( "legat120", "scott214", "user114", "serious", 1 ) )
                .AcqUserService( MsccCollectionObjectAcq.SERVICE )
                .build();

        MsccBeanAdapter.CollectionObject objectsData = service.getObjectsByKey( entity.getID() );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + objectsData.toString() );
        System.out.println( "-------------------------------");

    }




    @Test
    public void Object_getObjectReference_test()  {

        MsccBeanAdapter.SearchTerm t1 = new MsccBeanAdapter.SearchTerm( MsccConstants.MSCC_SEARCH_ORGANIZATION, "legat120" );
        MsccBeanAdapter.SearchTerm t2 = new MsccBeanAdapter.SearchTerm(MsccConstants.MSCC_SEARCH_OFFICE, "scott214" );
        //MsccBeanAdapter.SearchTerm t3 = new MsccBeanAdapter.SearchTerm(MsccConstants.MSCC_SEARCH_SEQUENCE, "2" );
//        MsccBeanAdapter.SearchTerm t4 = new MsccBeanAdapter.SearchTerm(MsccConstants.MSCC_SEARCH_REFNBR, "950" );

        MsccBeanAdapter.QueryCriteria q = new MsccBeanAdapter.QueryCriteria( );
        q.addFuzzyQuery( t1 );
        q.addFuzzyQuery( t2 );
        //q.addFuzzyQuery( t3 );

//        q.addFuzzyQuery( t2 ).addFuzzyQuery( t3 ).addFuzzyQuery( t4 );

        List<String> orderBy = new ArrayList<String>();
        orderBy.add( "Created");

        List<MsccBeanAdapter.CollectionObject.ID> objectsData = service.getObjectsByReference( q );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + objectsData.toString() );
        System.out.println( "-------------------------------");

    }



    @Test
    public void Folder_getCollectionsInFolder_test() {

        MsccBeanAdapter.Folder entity = MsccBeanAdapter.Folder.getBuilder()
                .ID( new MsccBeanAdapter.Folder.ID( "legat120", "scott124", "batman", "park" ) )
                .build();


        List<MsccBeanAdapter.Collection.ID> collectionData = service.getCollectionsInFolder( entity.getID() );

        System.out.println( "-------------------------------");
        System.out.println( "The result is: " + collectionData.toString() );
        System.out.println( "-------------------------------");

    }



    @Test
    public void Collection_getObjectsByCollection_test() {

        MsccBeanAdapter.Collection entity = MsccBeanAdapter.Collection.getBuilder()

                .ID( new MsccBeanAdapter.Collection.ID( "legat120", "scott214", "user114", "serious" ) )
                .Account( "123456789")
                .DialogShare(MsccCollectionDialogShare.ORGOWNER )
                .DialogType(MsccCollectionDialogType.ALLTYPE )
                .Folder( "piano" )
                .OrganizationCreator( "legat188")
                .build();

        List<MsccBeanAdapter.CollectionObject.ID> collectionObjects = service.getObjectsByCollection( entity.getID() );

        System.out.println( "-------------------------------");
        System.out.println( collectionObjects );
        System.out.println( "-------------------------------");

    }





}
