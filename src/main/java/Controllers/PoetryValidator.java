package Controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pagulane on 28.03.16.
 */
public class PoetryValidator {

    PoetryForm poetryData;
    List<String> errorList = new ArrayList<String>();

    public PoetryValidator(PoetryForm poetryData){
        this.poetryData = poetryData;
    }

    public List<String> validateForm(){
        validateTitle();
        validateContent();
        validateYear();
        return errorList;
    }

    public void validateTitle(){
        if(!(poetryData.getTitle().length() <= 50)){
            errorList.add("Title length is not valid! (<=50)");
        }
    }

    public void validateContent(){
        if(!(poetryData.getContent().length() <= 2500)){
            errorList.add("Content length is not valid! (<=2500)");
        }
    }

    public void validateYear(){
        if(!(poetryData.getYear() < 2016 && poetryData.getYear() > 1600)){
            errorList.add("Year is not in the acceptable range (1600-2016)");
        }
    }

    public Poetry convertToPoetry(){
        Poetry poetry = new Poetry();
        poetry.setId(poetryData.getId());
        poetry.setTitle(poetryData.getTitle());
        poetry.setContent(poetryData.getContent());
        poetry.setYear(poetryData.getYear());
        return poetry;
    }



}
