package BinckMap.BinckAPI.controller.model;

import BinckMap.BinckAPI.Interfaces.IStoryResponseBody;

public class StoryResponseBody implements IStoryResponseBody {

    private String name;
    private String subject;
    private String verhaal;

    public StoryResponseBody(String name, String subject, String verhaal) {
        this.name = name;
        this.subject = subject;
        this.verhaal = verhaal;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getVerhaal() {
        return this.verhaal;
    }

    @Override
    public void setVerhaal(String verhaal) {
        this.verhaal = verhaal;
    }
}
