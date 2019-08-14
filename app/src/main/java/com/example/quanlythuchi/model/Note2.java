package com.example.quanlythuchi.model;

public class Note2 {
    private String noteId2;
    private String noteTitle2;
    private Double noteContent2;

    public Note2(String noteId, String noteTitle, Double noteContent) {
        this.noteId2 = noteId;
        this.noteTitle2 = noteTitle;
        this.noteContent2 = noteContent;
    }

    public Note2(String noteTitle, Double noteContent) {
        this.noteTitle2 = noteTitle;
        this.noteContent2 = noteContent;
    }

    public Note2() {

    }

    public String getNoteId2() {
        return noteId2;
    }

    public void setNoteId2(String noteId2) {
        this.noteId2 = noteId2;
    }

    public String getNoteTitle2() {
        return noteTitle2;
    }

    public void setNoteTitle2(String noteTitle2) {
        this.noteTitle2 = noteTitle2;
    }

    public Double getNoteContent2() {
        return noteContent2;
    }

    public void setNoteContent2(Double noteContent2) {
        this.noteContent2 = noteContent2;
    }
}
