import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


public class CandidatSerializer implements JsonDeserializer<Candidate>, JsonSerializer<Candidate>
{
    @Override
    public JsonElement serialize(Candidate src, Type typeOfSrc, JsonSerializationContext context) 
    {
        JsonObject obj = new JsonObject();

        obj.addProperty("party_name", src.party_name());
        obj.addProperty("name", src.name());
        obj.addProperty("surname", src.name());
        obj.addProperty("sex", src.name());

        return obj;
    }

    @Override
    public Candidate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException 
    {
        JsonObject obj = new JsonObject();

        obj.add("party_name", json);
        obj.add("name", json);
        obj.add("surname", json);
        obj.add("sex", json);  

        return (new Gson()).fromJson(obj, typeOfT);
    }
}
