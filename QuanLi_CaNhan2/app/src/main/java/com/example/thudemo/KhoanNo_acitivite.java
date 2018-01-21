package com.example.thudemo;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import Database.DataAdapter;

public class KhoanNo_acitivite extends Activity {
    private Date dateFinish;
    private DataAdapter db;
    Calendar cal;
    Button Btdate1, Btdate2, Btthem1, bt_clearkn;
    ImageButton imgbt_backkn;
    EditText edittenn, editsotienn, editlaisuatn, editdate1, editdate2;
    ListView listviewtab;
    SimpleCursorAdapter cursordata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khoangno_activite);
        editdate1 = (EditText) findViewById(R.id.et_datekn);
        editdate2 = (EditText) findViewById(R.id.et_trakn);
        edittenn = (EditText) findViewById(R.id.et_tkn);
        editsotienn = (EditText) findViewById(R.id.editsotienkn);
        editlaisuatn = (EditText) findViewById(R.id.editlaisuatkn);
        Btdate1 = (Button) findViewById(R.id.btnno);
        Btdate2 = (Button) findViewById(R.id.btntrakn);
        Btthem1 = (Button) findViewById(R.id.btnthemkn);
        bt_clearkn = (Button) findViewById(R.id.bt_clearkn);
        imgbt_backkn = (ImageButton) findViewById(R.id.imgbt_backkn);
        listviewtab = (ListView) findViewById(R.id.lvkn);
        db = new DataAdapter(this);
        db.open();
        Cursor curn = db.getAllkn();
        startManagingCursor(curn);

        String[] from = new String[]{DataAdapter.tenkhoanno, DataAdapter.sotienn, DataAdapter.laisuatn, DataAdapter.ngayno, DataAdapter.ngaytrano};
        int[] to = new int[]{R.id.txtten, R.id.txtsotienkn, R.id.txtlaisuatkn, R.id.txtngayvaykn, R.id.txtngaytrakn};

        cursordata = new SimpleCursorAdapter(this, R.layout.row_khoanno, curn, from, to);
        listviewtab.setAdapter(cursordata);
        disAll();
        loadTabs();

        Btthem1.setEnabled(false);
        edittenn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((edittenn.getText().toString().equals("")) ||
                        editsotienn.getText().toString().equals("") ||
                        editlaisuatn.getText().toString().equals("") ||
                        editdate1.getText().toString().equals("") ||
                        editdate2.getText().toString().equals("")) {
                    Btthem1.setEnabled(false);
                } else Btthem1.setEnabled(true);
            }
        });
        editsotienn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((edittenn.getText().toString().equals("")) ||
                        editsotienn.getText().toString().equals("") ||
                        editlaisuatn.getText().toString().equals("") ||
                        editdate1.getText().toString().equals("") ||
                        editdate2.getText().toString().equals("")) {
                    Btthem1.setEnabled(false);
                } else Btthem1.setEnabled(true);
            }
        });
        editlaisuatn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((edittenn.getText().toString().equals("")) ||
                        editsotienn.getText().toString().equals("") ||
                        editlaisuatn.getText().toString().equals("") ||
                        editdate1.getText().toString().equals("") ||
                        editdate2.getText().toString().equals("")) {
                    Btthem1.setEnabled(false);
                } else Btthem1.setEnabled(true);
            }
        });
        editdate1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((edittenn.getText().toString().equals("")) ||
                        editsotienn.getText().toString().equals("") ||
                        editlaisuatn.getText().toString().equals("") ||
                        editdate1.getText().toString().equals("") ||
                        editdate2.getText().toString().equals("")) {
                    Btthem1.setEnabled(false);
                } else Btthem1.setEnabled(true);
            }
        });
        editdate2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((edittenn.getText().toString().equals("")) ||
                        editsotienn.getText().toString().equals("") ||
                        editlaisuatn.getText().toString().equals("") ||
                        editdate1.getText().toString().equals("") ||
                        editdate2.getText().toString().equals("")) {
                    Btthem1.setEnabled(false);
                } else Btthem1.setEnabled(true);
            }
        });


        Btdate1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getDefaultInforkn(editdate1);
                showDatePickerDialogkn(editdate1);
            }
        });
        Btdate2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getDefaultInforkn(editdate2);
                showDatePickerDialogkn(editdate2);
            }
        });
        Btthem1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                db.open();
                String tkn = edittenn.getText().toString();
                int st = Integer.parseInt(editsotienn.getText().toString());
                int ls = Integer.parseInt(editlaisuatn.getText().toString());
                String nn = editdate1.getText().toString();
                String nt = editdate2.getText().toString();

                db.insertkhoanno(tkn, st, ls, nn, nt);
                Toast.makeText(getApplicationContext(), "Bạn Thêm Thành Công: " + tkn, Toast.LENGTH_LONG).show();
                disAll();
                edittenn.setText(null);
                editsotienn.setText(null);
                editlaisuatn.setText(null);
                editdate1.setText(null);
                editdate2.setText(null);

            }
        });
        bt_clearkn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                edittenn.setText(null);
                editsotienn.setText(null);
                editlaisuatn.setText(null);
                editdate1.setText(null);
                editdate2.setText(null);
            }
        });
        imgbt_backkn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhoanNo_acitivite.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @SuppressWarnings("deprecation")
    private void disAll() {
        db.open();
        try {
            Cursor curn = db.getAllkn();
            startManagingCursor(curn);

            String[] from = new String[]{DataAdapter.tenkhoanno, DataAdapter.sotienn, DataAdapter.laisuatn, DataAdapter.ngayno, DataAdapter.ngaytrano};
            int[] to = new int[]{R.id.txtten, R.id.txtsotienkn, R.id.txtlaisuatkn, R.id.txtngayvaykn, R.id.txtngaytrakn};

            cursordata = new SimpleCursorAdapter(this, R.layout.row_khoanno, curn, from, to);
            listviewtab.setAdapter(cursordata);
            listviewtab.setOnItemClickListener(new OnItemClickListener() {

                @SuppressLint("NewApi")
                @Override
                public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                    // TODO Auto-generated method stub

                    Cursor cursor = (Cursor) parent.getItemAtPosition(position);

                    final int item_id = cursor.getInt(cursor.getColumnIndex(DataAdapter.colknID));

                    String item_tkn = cursor.getString(cursor.getColumnIndex(DataAdapter.tenkhoanno));
                    String item_st = cursor.getString(cursor.getColumnIndex(DataAdapter.sotienn));
                    String item_ls = cursor.getString(cursor.getColumnIndex(DataAdapter.laisuatn));
                    String item_nn = cursor.getString(cursor.getColumnIndex(DataAdapter.ngayno));
                    String item_nt = cursor.getString(cursor.getColumnIndex(DataAdapter.ngaytrano));

                    AlertDialog.Builder myDialog = new AlertDialog.Builder(KhoanNo_acitivite.this);

                    myDialog.setTitle("Delete/Edit?");
                    TextView dialogTxt_id = new TextView(KhoanNo_acitivite.this);

                    LayoutParams dialogTxt_idLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                    dialogTxt_id.setLayoutParams(dialogTxt_idLayoutParams);

                    dialogTxt_id.setText("->" + String.valueOf(position+1));

                    final EditText tenkn = new EditText(KhoanNo_acitivite.this);
                    final EditText st = new EditText(KhoanNo_acitivite.this);
                    st.setInputType(InputType.TYPE_CLASS_NUMBER);
                    final EditText ls = new EditText(KhoanNo_acitivite.this);
                    ls.setInputType(InputType.TYPE_CLASS_NUMBER);
                    final EditText nn = new EditText(KhoanNo_acitivite.this);
                    nn.setInputType(InputType.TYPE_CLASS_DATETIME);
                    final EditText nt = new EditText(KhoanNo_acitivite.this);
                    nt.setInputType(InputType.TYPE_CLASS_DATETIME);

                    LayoutParams tenkn_layoupa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams st_layoupa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams ls_layoupa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams nn_layopa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams nt_layopa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

                    tenkn.setLayoutParams(tenkn_layoupa);
                    st.setLayoutParams(st_layoupa);
                    ls.setLayoutParams(ls_layoupa);
                    nn.setLayoutParams(nn_layopa);
                    nt.setLayoutParams(nt_layopa);

                    tenkn.setText(item_tkn);
                    st.setText(item_st);
                    ls.setText(item_ls);
                    nn.setText(item_nn);
                    nt.setText(item_nt);

                    LinearLayout layout = new LinearLayout(KhoanNo_acitivite.this);

                    layout.setOrientation(LinearLayout.VERTICAL);

                    layout.addView(dialogTxt_id);

                    layout.addView(tenkn);
                    layout.addView(st);
                    layout.addView(ls);
                    layout.addView(nn);
                    layout.addView(nt);

                    myDialog.setView(layout);

                    myDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked

                        public void onClick(DialogInterface arg0, int arg1) {

                            LinearLayout layout = new LinearLayout(KhoanNo_acitivite.this);
                            AlertDialog.Builder builder = new AlertDialog.Builder(layout.getContext());
                            builder.setTitle("Hỏi Xóa");
                            builder.setMessage("Bạn Có Muốn Xóa Khoản Nợ Này Không?");
                            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    db.open();
                                    db.deletetkn(item_id);

                                    Cursor c = db.getAllkn();
                                    startManagingCursor(c);
                                    String[] from = new String[]{DataAdapter.tenkhoanno, DataAdapter.sotienn, DataAdapter.laisuatn, DataAdapter.ngayno, DataAdapter.ngaytrano};
                                    int[] to = new int[]{R.id.txtten, R.id.txtsotienkn, R.id.txtlaisuatkn, R.id.txtngayvaykn, R.id.txtngaytrakn};


                                    SimpleCursorAdapter notes = new SimpleCursorAdapter(KhoanNo_acitivite.this, R.layout.row_khoanno, c, from, to);
                                    listviewtab.setAdapter(notes);

                                    notes.notifyDataSetChanged();
                                    db.close();
                                }
                            });
                            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                }
                            });
                            builder.create().show();

                        }

                    });

                    myDialog.setNeutralButton("Update", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked

                        public void onClick(DialogInterface arg0, int arg1) {

                            String valt = tenkn.getText().toString();
                            int valst = Integer.parseInt(st.getText().toString());
                            int valls = Integer.parseInt(ls.getText().toString());
                            String valnv = nn.getText().toString();
                            String valnt = nt.getText().toString();
                            db.open();
                            db.updatekhoanno(item_id, valt, valst, valls, valnv, valnt);

                            Cursor c = db.getAllkn();
                            startManagingCursor(c);

                            String[] from = new String[]{DataAdapter.tenkhoanno, DataAdapter.sotienn, DataAdapter.laisuatn, DataAdapter.ngayno, DataAdapter.ngaytrano};
                            int[] to = new int[]{R.id.txtten, R.id.txtsotienkn, R.id.txtlaisuatkn, R.id.txtngayvaykn, R.id.txtngaytrakn};

                            SimpleCursorAdapter notes = new SimpleCursorAdapter(KhoanNo_acitivite.this, R.layout.row_khoanno, c, from, to);
                            listviewtab.setAdapter(notes);
                            Toast.makeText(getApplicationContext(), "Bạn Sửa Thành Công: " + valt, Toast.LENGTH_LONG).show();
                            notes.notifyDataSetChanged();
                            db.close();
                        }

                    });

                    myDialog.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {

                                // do something when the button is clicked

                                public void onClick(DialogInterface arg0, int arg1) {
                                }

                            });

                    myDialog.show();

                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        db.close();
    }

    public void loadTabs() {
        //Lấy Tabhost id ra trước (cái này của built - in android
        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        //gọi lệnh setup
        tab.setup();
        TabHost.TabSpec spec;
        //Tạo tab1
        spec = tab.newTabSpec("t1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Thêm Khoản Nợ");
        tab.addTab(spec);
        //Tạo tab2
        spec = tab.newTabSpec("t2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Danh Sách Khoản Nợ");
        tab.addTab(spec);
        //Thiết lập tab mặc định được chọn ban đầu là tab 0
        tab.setCurrentTab(0);
    }

    public void getDefaultInforkn(EditText editText) {
        //lấy ngày hiện tại của hệ thống
        cal = Calendar.getInstance();
        SimpleDateFormat dft = null;
        //Định dạng ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(cal.getTime());
        //hiển thị lên giao diện
        editText.setText(strDate);
        //gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
        dateFinish = cal.getTime();
    }

    public void showDatePickerDialogkn(final EditText editText) {
        OnDateSetListener callback = new OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView Date
                editText.setText((dayOfMonth) + "/" + (monthOfYear + 1) + "/" + year);
                //Lưu vết lại biến ngày hoàn thành
                cal.set(year, monthOfYear, dayOfMonth);
                dateFinish = cal.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
        //sẽ giống với trên TextView khi mở nó lên
        String s1 = editText.getText() + "";
        String strArrtmp1[] = s1.split("/");
        int ngayv = Integer.parseInt(strArrtmp1[0]);
        int thangv = Integer.parseInt(strArrtmp1[1]) - 1;
        int namv = Integer.parseInt(strArrtmp1[2]);
        DatePickerDialog pic1 = new DatePickerDialog(KhoanNo_acitivite.this, callback, namv, thangv, ngayv);
        pic1.setTitle("Chọn ngày hoàn thành");
        pic1.show();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
