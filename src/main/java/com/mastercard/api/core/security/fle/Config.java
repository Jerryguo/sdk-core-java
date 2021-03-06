package com.mastercard.api.core.security.fle;

import com.mastercard.api.core.exception.SdkException;
import com.mastercard.api.core.security.util.DataEncoding;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by e049519 on 3/14/17.
 */


public class Config {

    public List<String> triggeringEndPath = null;
    public List<String> fieldsToEncrypt = null;
    public List<String> fieldsToDecrypt = null;

    public String symmetricAlgorithm = null;
    public String symmetricCipher = null;
    public int symmetricKeysize = -1;
    public String asymmetricCipher = null;
    public String oaepHashingAlgorithm = null;
    public String publicKeyFingerprintHashing = null;


    public String ivFieldName = null;
    public String oaepHashingAlgorithmFieldName = null;
    public String encryptedKeyFiledName = null;
    public String encryptedDataFieldName = null;
    public String publicKeyFingerprintFiledName = null;

    public DataEncoding dataEncoding;

    public Config() {

    }

    protected void validate() {
        if (triggeringEndPath == null) {
            throw new SdkException("Config: triggetingEndPath is null");
        }
        if (fieldsToEncrypt == null) {
            throw new SdkException("Config: fieldsToEncrypt is null");
        }
        if (fieldsToDecrypt == null) {
            throw new SdkException("Config: fieldsToDecrypt is null");
        }
        if (symmetricAlgorithm == null) {
            throw new SdkException("Config: symmetricAlgorithm is null");
        }
        if (symmetricCipher == null) {
            throw new SdkException("Config: symmetricCipher is null");
        }
        if (symmetricKeysize == -1) {
            throw new SdkException("Config: symmetricKeysize is not set");
        }
        if (asymmetricCipher == null) {
            throw new SdkException("Config: asymmetricCipher is null");
        }
        if (oaepHashingAlgorithm == null) {
            throw new SdkException("Config: oaepHashingAlgorithm is null");
        }
        if (publicKeyFingerprintHashing == null) {
            throw new SdkException("Config: publicKeyFingerprintHashing is null");
        }
        if (ivFieldName == null) {
            throw new SdkException("Config: ivFieldName is null");
        }
        if (oaepHashingAlgorithmFieldName == null) {
            throw new SdkException("Config: oaepHashingAlgorithmFieldName is null");
        }
        if (encryptedKeyFiledName == null) {
            throw new SdkException("Config: encryptedKeyFiledName is null");
        }
        if (encryptedDataFieldName == null) {
            throw new SdkException("Config: encryptedDataFieldName is null");
        }
        if (publicKeyFingerprintFiledName == null) {
            throw new SdkException("Config: publicKeyFingerprintFiledName is null");
        }
    }

    public final static Config parseFromJson(String json) {
        JSONObject object =(JSONObject) JSONValue.parse(json);
        Config tmpConfig = new Config();
        if (object.containsKey("triggeringEndPath") && object.get("triggeringEndPath") instanceof JSONArray) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (ListIterator<String> iterator = ((JSONArray)object.get("triggeringEndPath")).listIterator(); iterator.hasNext();) {
                tmp.add(iterator.next());
            }
            tmpConfig.triggeringEndPath = tmp;
        }

        if (object.containsKey("fieldsToEncrypt") && object.get("fieldsToEncrypt") instanceof JSONArray) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (ListIterator<String> iterator = ((JSONArray)object.get("fieldsToEncrypt")).listIterator(); iterator.hasNext();) {
                tmp.add(iterator.next());
            }
            tmpConfig.fieldsToEncrypt = tmp;
        }

        if (object.containsKey("fieldsToDecrypt") && object.get("fieldsToDecrypt") instanceof JSONArray) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (ListIterator<String> iterator = ((JSONArray)object.get("fieldsToDecrypt")).listIterator(); iterator.hasNext();) {
                tmp.add(iterator.next());
            }
            tmpConfig.fieldsToDecrypt = tmp;
        }

        tmpConfig.symmetricAlgorithm = (String) object.get("symmetricAlgorithm");
        tmpConfig.symmetricCipher = (String) object.get("symmetricCipher");
        if(object.containsKey("symmetricKeysize")) {
            try{
                tmpConfig.symmetricKeysize = Integer.parseInt(object.get("symmetricKeysize").toString());
            } catch (NumberFormatException e) {
            }

        }

        tmpConfig.asymmetricCipher = (String) object.get("asymmetricCipher");
        tmpConfig.oaepHashingAlgorithm = (String) object.get("oaepHashingAlgorithm");
        tmpConfig.publicKeyFingerprintHashing = (String) object.get("publicKeyFingerprintHashing");

        tmpConfig.ivFieldName = (String) object.get("ivFieldName");
        tmpConfig.oaepHashingAlgorithmFieldName = (String) object.get("oaepHashingAlgorithmFieldName");
        tmpConfig.encryptedKeyFiledName = (String) object.get("encryptedKeyFiledName");
        tmpConfig.encryptedDataFieldName = (String) object.get("encryptedDataFieldName");
        tmpConfig.publicKeyFingerprintFiledName = (String) object.get("publicKeyFingerprintFiledName");

        String dataEncoding = (String) object.get("dataEncoding");
        if (dataEncoding.toLowerCase().compareTo("hex") == 0) {
            tmpConfig.dataEncoding = DataEncoding.HEX;
        } else {
            tmpConfig.dataEncoding = DataEncoding.BASE64;
        }

        tmpConfig.validate();

        return tmpConfig;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Config config = (Config) o;

        if (symmetricKeysize != config.symmetricKeysize) return false;
        if (triggeringEndPath != null ? !triggeringEndPath.equals(config.triggeringEndPath) : config.triggeringEndPath != null)
            return false;
        if (fieldsToEncrypt != null ? !fieldsToEncrypt.equals(config.fieldsToEncrypt) : config.fieldsToEncrypt != null)
            return false;
        if (fieldsToDecrypt != null ? !fieldsToDecrypt.equals(config.fieldsToDecrypt) : config.fieldsToDecrypt != null)
            return false;
        if (symmetricAlgorithm != null ? !symmetricAlgorithm.equals(config.symmetricAlgorithm) : config.symmetricAlgorithm != null)
            return false;
        if (symmetricCipher != null ? !symmetricCipher.equals(config.symmetricCipher) : config.symmetricCipher != null)
            return false;
        if (asymmetricCipher != null ? !asymmetricCipher.equals(config.asymmetricCipher) : config.asymmetricCipher != null)
            return false;
        if (oaepHashingAlgorithm != null ? !oaepHashingAlgorithm.equals(config.oaepHashingAlgorithm) : config.oaepHashingAlgorithm != null)
            return false;
        if (publicKeyFingerprintHashing != null ? !publicKeyFingerprintHashing.equals(config.publicKeyFingerprintHashing) : config.publicKeyFingerprintHashing != null)
            return false;
        if (ivFieldName != null ? !ivFieldName.equals(config.ivFieldName) : config.ivFieldName != null) return false;
        if (oaepHashingAlgorithmFieldName != null ? !oaepHashingAlgorithmFieldName.equals(config.oaepHashingAlgorithmFieldName) : config.oaepHashingAlgorithmFieldName != null)
            return false;
        if (encryptedKeyFiledName != null ? !encryptedKeyFiledName.equals(config.encryptedKeyFiledName) : config.encryptedKeyFiledName != null)
            return false;
        if (encryptedDataFieldName != null ? !encryptedDataFieldName.equals(config.encryptedDataFieldName) : config.encryptedDataFieldName != null)
            return false;
        return publicKeyFingerprintFiledName != null ? publicKeyFingerprintFiledName.equals(config.publicKeyFingerprintFiledName) : config.publicKeyFingerprintFiledName == null;
    }

    @Override
    public int hashCode() {
        int result = triggeringEndPath != null ? triggeringEndPath.hashCode() : 0;
        result = 31 * result + (fieldsToEncrypt != null ? fieldsToEncrypt.hashCode() : 0);
        result = 31 * result + (fieldsToDecrypt != null ? fieldsToDecrypt.hashCode() : 0);
        result = 31 * result + (symmetricAlgorithm != null ? symmetricAlgorithm.hashCode() : 0);
        result = 31 * result + (symmetricCipher != null ? symmetricCipher.hashCode() : 0);
        result = 31 * result + symmetricKeysize;
        result = 31 * result + (asymmetricCipher != null ? asymmetricCipher.hashCode() : 0);
        result = 31 * result + (oaepHashingAlgorithm != null ? oaepHashingAlgorithm.hashCode() : 0);
        result = 31 * result + (publicKeyFingerprintHashing != null ? publicKeyFingerprintHashing.hashCode() : 0);
        result = 31 * result + (ivFieldName != null ? ivFieldName.hashCode() : 0);
        result = 31 * result + (oaepHashingAlgorithmFieldName != null ? oaepHashingAlgorithmFieldName.hashCode() : 0);
        result = 31 * result + (encryptedKeyFiledName != null ? encryptedKeyFiledName.hashCode() : 0);
        result = 31 * result + (encryptedDataFieldName != null ? encryptedDataFieldName.hashCode() : 0);
        result = 31 * result + (publicKeyFingerprintFiledName != null ? publicKeyFingerprintFiledName.hashCode() : 0);
        return result;
    }
}
