package BinckMap.BinckAPI.Interfaces;

public interface ICompanyRequestBody {
    String getName();
    void setName(String Name);

    String getDescription();
    void setDescription(String description);

    double getLat1();
    void setLat1(double lat1);

    double getLat2();
    void setLat2(double lat1);

    double getLong1();
    void setLong1(double lat1);

    double getLong2();
    void setLong2(double lat1);
}
