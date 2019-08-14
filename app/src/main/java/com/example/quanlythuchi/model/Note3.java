package com.example.quanlythuchi.model;

public class Note3 {
    private String noteId3;
    private String noteTitle3;
    private Double noteContent3;

    public Note3(String noteId, String noteTitle, Double noteContent) {
        this.noteId3 = noteId;
        this.noteTitle3 = noteTitle;
        this.noteContent3 = noteContent;
    }

    public Note3(String noteTitle, Double noteContent) {
        this.noteTitle3 = noteTitle;
        this.noteContent3 = noteContent;
    }

    public Note3() {

    }

    public String getNoteId3() {
        return noteId3;
    }

    public void setNoteId3(String noteId3) {
        this.noteId3 = noteId3;
    }

    public String getNoteTitle3() {
        return noteTitle3;
    }

    public void setNoteTitle3(String noteTitle3) {
        this.noteTitle3 = noteTitle3;
    }

    public Double getNoteContent3() {
        return noteContent3;
    }

    public void setNoteContent3(Double noteContent3) {
        this.noteContent3 = noteContent3;
    }
}
