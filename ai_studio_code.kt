package com.example.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.AppFooter
import com.example.ui.theme.AfghanLapisPrimary
import com.example.ui.theme.AfghanTealSecondary

@Composable
fun AddInformationForm(
    onSave: (title: String, category: String, province: String, imageUri: String?, desc: String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("provinces") }
    var province by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }
    var description by remember { mutableStateOf("") }

    val pickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) imageUri = uri.toString()
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        // باکس اول: عنوان مطلب
        item {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text("باکس اول: عنوان مطلب", fontWeight = FontWeight.Bold)
                    OutlinedTextField(value = title, onValueChange = { title = it }, modifier = Modifier.fillMaxWidth())
                }
            }
        }
        // باکس دوم: بخش (دسته‌بندی)
        item {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text("باکس دوم: بخش (دسته‌بندی)", fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf("provinces" to "ولایات", "parks" to "پارک‌ها", "foods" to "غذاها", "traditions" to "رسوم").forEach { (key, label) ->
                            FilterChip(selected = category == key, onClick = { category = key }, label = { Text(label) })
                        }
                    }
                }
            }
        }
        // باکس سوم: نام ولایت
        item {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text("باکس سوم: نام ولایت", fontWeight = FontWeight.Bold)
                    OutlinedTextField(value = province, onValueChange = { province = it }, modifier = Modifier.fillMaxWidth())
                }
            }
        }
        // باکس چهارم: افزودن تصویر
        item {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text("باکس چهارم: افزودن تصویر", fontWeight = FontWeight.Bold)
                    Button(
                        onClick = { pickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
                        colors = ButtonDefaults.buttonColors(containerColor = AfghanTealSecondary)
                    ) {
                        Icon(imageVector = Icons.Default.AddPhotoAlternate, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("انتخاب از گالری گوشی")
                    }
                }
            }
        }
        // دکمه ذخیره
        item {
            Button(
                onClick = { onSave(title, category, province, imageUri, description) },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AfghanLapisPrimary)
            ) {
                Text("ثبت اطلاعات در راهنمای افغانستان", fontWeight = FontWeight.Bold)
            }
        }
        // فوتر ارتباطی در انتهای صفحه
        item {
            AppFooter(currentLanguage = com.example.data.model.AppLanguage.DARI)
        }
    }
}